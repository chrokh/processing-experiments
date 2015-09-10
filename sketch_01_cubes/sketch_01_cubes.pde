int tick = 0;

void setup() {
  size(600, 600, P3D);
  background(0);
  stroke(255);
  noFill();
  
  int zoomSpeed = 500;
  
  new Cube(300, 300, 0, new Stepper(0, Cubes.MAX_SIZE, zoomSpeed), new MassSpin());
  new Cube(300, 300, 0, new Stepper(0, 350, zoomSpeed), new MassSpin());
  new Cube(300, 300, 0, new Stepper(0, 60, zoomSpeed), new MassSpin());
  new Cube(300, 300, 0, new Stepper(0, 5, zoomSpeed), new MassSpin(), 255);
}

void draw() {
  tick += 1;
  background(0);
  Cubes.draw();

}

static class Cubes {
  private static ArrayList<Cube> cubes = new ArrayList<Cube>();
  public static final int MAX_SIZE = 2000;

  static void draw() {
    for (Cube c : Cubes.cubes) {
      c.draw();
    }
  }

  static void add(Cube cube) {
    Cubes.cubes.add(cube);
  }
  
  static int count() {
    return Cubes.cubes.size();
  }
  
  static int getNextId() {
    return Cubes.cubes.size();
  }
}


class Cube {
  private float x;
  private float y;
  private float size;
  private int id;
  private int col = Integer.MIN_VALUE;
  private Stepper stepper;
  private ISpinner spinner;
  private PVector rotation = new PVector(0,0,0);

  public Cube(float x, float y, float size, Stepper stepper, ISpinner spinner, int col) {
    this(x, y, size, stepper, spinner);
    this.col = col;
  }
  
  public Cube(float x, float y, float size, Stepper stepper, ISpinner spinner) {
    this.x = x;
    this.y = y;
    this.size = 100;
    this.id = Cubes.getNextId();
    this.stepper = stepper;
    this.spinner = spinner;
    Cubes.add(this);
  }
  
  public float getSize() {
    return this.size;
  }
  

  void draw() {
    pushMatrix();
    
    if(this.stepper.isDone()){
      this.stepper = this.stepper.inverse();
    }
    
    this.size = this.stepper.next();
    
    this.rotation.z += this.spinner.nextZ(this);
    this.rotation.y += this.spinner.nextY(this);
     
     
    translate(this.x, this.y, 0);
    rotateZ(this.rotation.z);
    rotateY(this.rotation.y);
    
    if(this.col != Integer.MIN_VALUE) {
      fill(this.col);
    }
    
    box(size);
    
    popMatrix();
    noFill();
  }
}

class Stepper {
  boolean isDone = false;
  float from;
  float to;
  float index;
  float steps;
  
  public Stepper(float from, float to, float steps) {
    this.from = from;
    this.to = to;
    this.steps = steps == 0 ? 1 : steps;
    this.steps = steps;
    this.index = from;
  }
  
  float next() {
    if(this.isDone())
      return this.index;
    else if(this.from < this.to) {
      this.index += abs(from - to) / this.steps;
    } else {
      this.index -= abs(from - to) / this.steps;
    }
    
    return this.index < 0 ? 0 : this.index;      
  }
  
  boolean isDone() {
    return (this.from < this.to && this.index >= this.to)
        || (this.from > this.to && this.index <= this.to);
  }
  
  Stepper inverse() {
    return new Stepper(this.to, this.from, this.steps);
  }
}

interface ISpinner {
  public float nextZ(Cube cube);
  public float nextY(Cube cube);
}

class SlowSpin implements ISpinner {
  public float nextZ(Cube cube) {
    return 0;
  }
  
  public float nextY(Cube cube) {
    return 0.005;
  }
}

class MassSpin implements ISpinner {
  public float nextZ(Cube cube) {
    return this.nextY(cube) * 0.2;
  }
  
  public float nextY(Cube cube) {
    float max = 0.04;
    float min = 0.0001;
    float dist = max - min;
    float frac = cube.getSize() / Cubes.MAX_SIZE;
    float step = frac * dist;
    return max - step;
  }
}
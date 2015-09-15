int tick = 0;
int speed = 10;
int iterations = 30;

void setup() {
  size(600, 600);
  smooth();
  noFill(); 
  print("Use mouse y to control speed of change \r\n");
  print("Use mouse x to control number of shapes");
}

void draw() {
  if(tick % speed == 0) {
    color c = color(random(255), random(255), random(255));
    int sides = round(tick / speed); 
    background(#202020);
    DynamicShape d = new DynamicShape(sides, 300, 300, 300, 0, c, c);
    translate(width/2, height/2);
    rotate(radians(random(360)));
    translate(-width/2, -height/2);
    d.draw();
    speed = mouseY / 50 + 1;
    iterations = mouseX / 10 + 1;
  }

  if(tick < iterations * speed) { 
    tick += 1;
  } else {
    tick = 0;
  }
}


class DynamicShape {
  float x;
  float y;
  float size;
  float weight;
  int sides;
  color fill;
  color stroke;

  public DynamicShape(int sides, float x, float y, float size, float weight, color fill, color stroke) {
    this.x = x;
    this.y = y;
    this.size = size;
    this.sides  = abs(sides);
    this.fill   = fill;
    this.stroke = stroke;
    this.weight = weight;
  }

  public void draw() {
    stroke(this.stroke);
    strokeWeight(this.weight);
    fill(this.fill);
    this.shape().draw();
  }

  public IShape shape() {
    switch(this.sides) {
      case 0:
        return new Circle(this.x, this.y, this.size, this.size);
      case 1:
        return new Drop(this.x, this.y, this.size);
      case 2:
        return new Mouth(this.x, this.y, this.size);
      case 3:
        return new Triangle(this.x, this.y, this.size);
      case 4:
        return new Rectangle(this.x, this.y, this.size);
      default:
        return new Polygon(this.x, this.y, this.size, this.sides);
    }
  }
}

interface IShape {
  void draw();
}

class Circle implements IShape {
  float x;
  float y;
  float w;
  float h;

  public Circle (float x, float y, float w, float h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  void draw() {
    ellipse(this.x, this.y, this.w, this.h);
  }
}

class HalfDrop implements IShape {
  float x1;
  float y1;
  float px1;
  float py1;
  float x2;
  float y2;
  float px2;
  float py2;

  public HalfDrop(float x, float y, float width, float height) {
    this.x1  = x;
    this.y1  = y - height / 2;
    this.px1 = this.x1 + width / 2;
    this.py1 = this.y1 + height / 4;
    this.x2  = x;
    this.y2  = y + height / 2;
    this.px2 = x + width;
    this.py2 = this.y2;
  }

  void draw() {
    bezier(this.x1, this.y1, this.px1, this.py1, this.px2, this.py2, this.x2, this.y2);
  }
}

class Drop implements IShape {
  IShape left;
  IShape right;

  public Drop(float x, float y, float size) {
    this.left = new HalfDrop(x, y, size, size);
    this.right = new HalfDrop(x, y, -size, size);
  }

  void draw() {
    this.left.draw();
    this.right.draw();
  }
}

class Mouth implements IShape {
  IShape left;
  IShape right;

  public Mouth(float x, float y, float size) {
    this.left = new HalfDrop(x, y, size, size);
    this.right = new HalfDrop(x, y, -size, -size);
  }

  void draw() {
    this.left.draw();
    this.right.draw();
  }
}

class Triangle implements IShape {
  float x1;
  float y1;
  float x2;
  float y2;
  float x3;
  float y3;

  public Triangle(float x, float y, float size) {
    this.x1 = x - size / 2;
    this.y1 = y + size / 2;
    this.x2 = x;
    this.y2 = y - size / 2;
    this.x3 = x + size / 2;
    this.y3 = y + size / 2;
  }

  void draw() {
    triangle(this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
  }
}

class Rectangle implements IShape {
  float x;
  float y;
  float size;

  public Rectangle(float x, float y, float size) {
    this.x = x - size / 2;
    this.y = y - size / 2;
    this.size = size;
  }

  void draw() {
    rect(this.x, this.y, this.size, this.size);
  }
}


class Polygon implements IShape {
  float x;
  float y;
  float size;
  int sides;

  public Polygon(float x, float y, float size, int sides) {
    this.x = x;
    this.y = y;
    this.size = size;
    this.sides = sides;
  }

  void draw() {
    // from: https://processing.org/examples/regularpolygon.html
    float angle = TWO_PI / this.sides;
    beginShape();
    for (float a = 0; a < TWO_PI; a += angle) {
      float sx = x + cos(a) * this.size / 2;
      float sy = y + sin(a) * this.size / 2;
      vertex(sx, sy);
    }
    endShape(CLOSE);
  }
}
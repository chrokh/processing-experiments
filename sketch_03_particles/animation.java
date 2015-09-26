import java.util.ArrayList;
import processing.core.PVector;
import processing.core.PApplet;
import static java.lang.System.out;

class Animation {
  ArrayList<Explosion> explosions;
  int counter;
  PApplet app;

  public Animation(PApplet app) {
    this.app = app;
    this.setup();
  }

  private void setup() {
    this.explosions = new ArrayList<Explosion>();
    this.counter = 0;
    PVector pos = new PVector(300, 300);
    int density = 250;
    float speed = 0.8f;
    float size  = 15f;
    int multitasking = 3000;
    float velMax = 2.5f;
    explosions.add(new Explosion(app, pos, density, multitasking, speed, size, velMax));
  }

  public void update() {
    if(counter < 100) {
      this.counter++;
      for(Explosion e : this.explosions)
        e.update();
    } else {
      this.setup();
    }
  }

  public void draw() {
    for(Explosion e : this.explosions)
      e.draw();
  }
}



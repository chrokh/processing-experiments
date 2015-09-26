import java.util.ArrayList;
import processing.core.PVector;
import processing.core.PApplet;

class Explosion {
  ArrayList<Particle> particles;
  PVector position;
  int density;
  float speed;
  float multitasking;
  float size;
  float velMax;
  PApplet app;

  public Explosion(PApplet app, PVector position, int density, float multitasking, float speed, float size, float velMax) {
    this.app   = app;
    this.position = position;
    this.density  = density;
    this.multitasking = multitasking;
    this.speed    = speed;
    this.size     = size;
    this.velMax   = velMax;
    this.particles = new ArrayList<Particle>();
  }

  public void update() {
    if(this.particles.size() < this.density) {
      if(app.random(0,1) <= this.speed)
        for(int i=0; i<_howMany(); i++)
          this.particles.add(_newParticle());
    }
  }

  public void draw() {
    for(Particle p : this.particles) {
      p.update();
      p.draw();
    }
  }

  private int _howMany() {
    if(this.multitasking > 0)
      return app.round(app.random(1, multitasking));
    else
      return 1;
  }

  private Particle _newParticle() {
    PVector pos = new PVector(position.x, position.y);
    PVector vel = new PVector(app.random(-this.velMax, this.velMax), app.random(-this.velMax, this.velMax));
    float sizeMin = this.size * 0.5f;
    float sizeMax = this.size * 1.5f;
    float size = app.random(sizeMin, sizeMax);
    float halflife = 0.00000001f;
    int maxlife = 75;
    return new Particle(app, pos, vel, size, maxlife, halflife);
  }
}

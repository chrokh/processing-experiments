import processing.core.PVector;
import processing.core.PApplet;

class Particle {
  PVector position;
  PVector velocity;
  int col;
  float size;
  float halflife;
  int maxlife;
  float life;
  PApplet app;

  public Particle(PApplet app, PVector position, PVector velocity, float size, int maxlife, float halflife) {
    this.app      = app;
    this.position = position;
    this.velocity = velocity;
    this.size     = size;
    this.halflife = halflife;
    this.maxlife  = maxlife;
    this.life     = maxlife;
    this.col      = app.color(255);
  }

  public void update() {
    this.position.add(this.velocity);
    //this.velocity.x = this.velocity.x / 10;
    //this.velocity.y = this.velocity.y / 10;
    this.life -= this.life * this.halflife;
    int lifecol = (255 / this.maxlife) * (int)this.life;
    this.col = app.color(this.col, lifecol);
  }

  public void draw() {
    app.noStroke();
    app.fill(this.col);
    app.ellipse(this.position.x, this.position.y, this.size, this.size);
  }
}

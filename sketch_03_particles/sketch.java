import java.util.ArrayList;
import java.util.List;

class Sketch {
  List<ParticleAnimation> animations;
  int counter;

  public Sketch() {
    this.setup();
  }

  private void setup() {
    this.counter = 0;
    this.animations = new ArrayList<ParticleAnimation>();
    this.animations.add(new Explosion());
  }

  public void update() {
    if(counter > 100)
      this.setup();
    this.counter++;

    for(ParticleAnimation anim : this.animations)
      anim.update();
  }

  public void draw() {
    for(ParticleAnimation anim : this.animations)
      anim.draw();
  }
}



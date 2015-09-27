import java.util.ArrayList;
import java.util.List;

class Animation {
  List<IParticles> particless;
  int counter;

  public Animation() {
    this.setup();
  }

  private void setup() {
    this.counter = 0;
    this.particless = new ArrayList<IParticles>();

    for(int i=0; i<80; i++) {
      List<ISpawner> spawners = new ArrayList<ISpawner>();
      spawners.add(new SmokeSpawner(5));
      this.particless.add(new Particles(spawners));
    }
  }

  public void update() {
    if(counter > 100)
      this.setup();
    this.counter++;

    for(IParticles ps : this.particless)
      ps.update();
  }

  public void draw() {
    for(IParticles ps : this.particless)
      ps.draw();
  }
}



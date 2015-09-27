import java.util.ArrayList;

class SmokeSpawner implements ISpawner {

  int limit;

  public SmokeSpawner(int limit) {
    this.limit = limit;
  }

  public boolean canSpawn() {
    return limit > 0;
  }

  public IParticle spawn() {
    if(limit > 0) {
      limit--;

      IParticle p = new Particle();
      p.run(new RunPosRand(300, 300, 10));
      p.run(new RunVelRand(1.2f));
      p.run(new RunMagRand(10, 20));
      p.run(new RunCol(new Color(255, 255, 255, 200)));
      p.addMod(new FadeMod(4, 0.2f));

      return p;
    }

    return null;
  }

}

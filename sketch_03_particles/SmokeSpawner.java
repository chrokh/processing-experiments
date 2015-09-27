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
      p.run(new RunVelRand(3));
      p.run(new RunMagRand(10, 20));
      p.run(new RunCol(255));
      //p.addMod(new ModVelDec());

      return p;
    }

    return null;
  }

}

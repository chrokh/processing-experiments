import java.util.ArrayList;

class PieceSpawner implements ISpawner {

  int limit;

  public PieceSpawner(int limit) {
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
      p.run(new RunVelRand(5));
      p.run(new RunMagRand(1, 5));
      p.run(new RunCol(140));
      p.addMod(new GravityMod());
      p.addMod(new FadeMod(1));

      return p;
    }

    return null;
  }

}

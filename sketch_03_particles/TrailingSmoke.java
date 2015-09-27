import java.util.ArrayList;

class TrailingSmoke implements ISpawner {

  IParticle first;
  float gravity = 0.2f;
  int i = 0;
  int delay = 1;

  public boolean canSpawn() {
    return true;
  }

  public IParticle spawn() {
    if(this.first == null)
      return this._spawnFirst();
    else
      return this._spawnNext();
  }

  private IParticle _spawnFirst() {
    this.first = new Particle();
    this.first.run(new RunPosRand(300, 300, 10));
    this.first.run(new RunVelRand(4));
    this.first.run(new RunMagRand(2, 5));
    this.first.run(new RunCol(80));
    this.first.addMod(new GravityMod(this.gravity));

    return this.first;
  }

  private IParticle _spawnNext() {
    Vec pos  = this.first.getPos();
    float x = pos.x();
    float y = pos.y();

    IParticle particle = new Particle();
    particle.run(new RunPosRand(x, y, 1));
    particle.run(new RunVelRand(0));
    particle.run(new RunMagRand(2, 5));
    particle.run(new RunCol(140));
    particle.addMod(new GravityMod(this.gravity));
    particle.addMod(new GrowMod(1.02f));

    return particle;
  }

}

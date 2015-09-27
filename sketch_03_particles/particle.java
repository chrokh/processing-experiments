import java.util.ArrayList;
import java.util.List;

class Particle implements IParticle {

  List<IMod> mods = new ArrayList<IMod>();

  Vec pos;
  Vec vel;
  Vec mag;
  Color col;

  public Particle() { }
  public Particle(List<IRun> runs, ArrayList<IMod> mods) {
    this.mods = mods;

    for(IRun r : runs)
      r.run(this);
  }

  public void setPos(Vec pos) {
    this.pos = pos;
  }

  public void setVel(Vec vel) {
    this.vel = vel;
  }

  public void setMag(Vec mag) {
    this.mag = mag;
  }

  public void setCol(Color col) {
    this.col = col;
  }

  public Vec getPos() {
    return this.pos;
  }

  public Vec getVel() {
    return this.vel;
  }

  public Vec getMag() {
    return this.mag;
  }

  public Color getCol() {
    return this.col;
  }



  public void run(IRun run) {
    run.run(this);
  }

  public void addMod(IMod mod) {
    this.mods.add(mod);
  }

  public void update() {
    for(IMod mod : mods)
      mod.mod(this);

    this.pos = this.pos.add(this.vel);
  }

  public void draw() {
    App.get().noStroke();
    App.get().fill(this.col.toInt());
    App.get().ellipse(this.pos.x(), this.pos.y(), this.mag.x(), this.mag.y());
  }
}

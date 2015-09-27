class ModVelDec implements IMod {

  public void mod(IParticle p) {
    Vec m = new Vec(0.991, 0.991);
    p.setVel(p.getVel().mult(m));
  }

}

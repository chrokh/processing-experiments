interface IParticle {
  public void update();
  public void draw();

  public void run (IRun run);
  public void addMod(IMod mod);

  public void setPos(Vec v);
  public void setVel(Vec v);
  public void setMag(Vec v);
  public void setCol(Color c);

  public Vec getPos();
  public Vec getVel();
  public Vec getMag();
  public Color getCol();
}

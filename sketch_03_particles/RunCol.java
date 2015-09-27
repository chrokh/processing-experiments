class RunCol implements IRun{

  int col;

  public RunCol(int col) {
    this.col = col;
  }

  public void run(IParticle p) {
    p.setCol(this.col);
  }

}


Sketch sketch;

void setup() {
  size(600, 600);
  background(0);
  App.set(this);
  sketch = new Sketch();
}


void draw() {
  background(0);
  sketch.update();
  sketch.draw();
}


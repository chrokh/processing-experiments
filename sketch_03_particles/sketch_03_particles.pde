Animation animation;

void setup() {
  size(600, 600);
  background(0);
  App.set(this);
  animation = new Animation();
}


void draw() {
  background(0);
  animation.update();
  animation.draw();
}


Animation animation;

void setup() {
  size(600, 600);
  background(#000000);
  print(this);
  animation = new Animation(this);
}


void draw() {
  background(#000000);
  animation.update();
  animation.draw();
}



import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

// //your code here
// Particle[] oddPart = new Particle [1000];

// JumboParticle[] biggie = new JumboParticle[15];

Particle[] part = new Particle [2000];
public void setup()
{
	size(800,800);//your code here
	
	for (int i=0;i<part.length;i++) 
	{
		part[i] = new NormalParticle();
	}
	part[0] = new OddballParticle();
	part[1] = new JumboParticle();

	// for (int i=0;i<oddPart.length;i++)
	// {
	// 	oddPart[i]= new OddballParticle();
	// }
	// for (int i=0;i<biggie.length;i++)
	// {
	// 	biggie[i]= new JumboParticle();
	// }
}
// void mouseWheel() 
// {
// 	for (int i = 0;i<oddPart.length;i++)
// 	{
// 		oddPart[i].move();
// 		oddPart[i].show();
// 	}
// }
// void mouseClicked()
// {
// 	for (int i = 0;i<biggie.length;i++)
// 	{
// 		biggie[i].move();
// 		biggie[i].show();
// 	}	
// }
public void draw()
{
	background(0);
	for (int i = 0;i<part.length;i++)
	{
		part[i].move();
		part[i].show();
	}
}
interface Particle
{
	public void show();
	public void move();
}
class NormalParticle implements Particle 
{
	double x, y, speed, angle;

	int siz = ((int)(Math.random()*6)+4);
	NormalParticle ()
	{
		// x=(double)(Math.random()*801);
		// y=(double)(Math.random()*801);
		x=(int)(400);
		y=(int)(400);
		speed=(int)(Math.random()*8);
		angle=(int)(Math.random()*360);
	}
	public void move()
	{
		x = x + Math.cos(angle)*speed;
		y = y + Math.sin(angle)*speed;
	}
	public void show()
	{
		fill((int)(Math.random()*255));
		ellipse((float)x, (float)y, siz, siz);
	}
}

class OddballParticle implements Particle
{
	double x2, y2, speed2, angle2;

	int siz = ((int)(Math.random()*10)+5);
	OddballParticle ()
	{
		x2=(double)400;
		y2=(double)400;
		speed2=(int)(Math.random()*15);
		angle2=(int)(Math.random()*360);
	}
	public void move()
	{
		x2 = x2 + Math.cos(angle2)*speed2;
		y2 = y2 + Math.sin(angle2)*speed2;
	}
	public void show()
	{ 
		fill((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256),((int)(Math.random()*255)));
		noStroke();
		ellipse((float)x2, (float)y2, siz, siz);
	}
}

class JumboParticle extends NormalParticle 
{
	double x, y, speed, angle;
	JumboParticle ()
	{
		x=(int)(400);
		y=(int)(400);
		speed=(int)(Math.random()*8);
		angle=(int)(Math.random()*360);
	}
	public void move()
	{
		x = x + Math.cos(angle)*speed;
		y = y + Math.sin(angle)*speed;
	}
	public void show()
	{
		fill((int)(Math.random()*255));
		triangle((int)x, (int)y, (int)x+10, (int)y, (int)x+5, (int)y+10);
	}

}



  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

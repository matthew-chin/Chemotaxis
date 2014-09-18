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

public class Chemotaxis extends PApplet {

Bacteria[] germ = new Bacteria[10];

public void setup()   
{     
	size(300,300);
	background(152,251,152);
	fill(255,255,255,100);
	ellipse(150,150,250,250);
	frameRate(250);
	for(int i = 0; i < germ.length; i++)
	{
		germ[i] = new Bacteria((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
	}

}   
public void draw()   
{ 
	int i = 0;
	while(i < germ.length)
	{
		germ[i].die();
		germ[i].move();
		germ[i].show();
		if(germ[i].siz < 1.5f)
		{
			germ[i] = new Bacteria((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));	

		}
		if(dist(germ[i].x, germ[i].y, 150, 150) > 125)
		{
			germ[i] = new Bacteria((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));	
		}
		i++;
	} 
}

class Bacteria    
{     
	float x, y;
	float siz;
	int r, g, b;

	Bacteria(int tempr, int tempg, int tempb)
	{
		x = 150 + (int)(Math.random()*177)-88;
		y = 150 + (int)(Math.random()*177)-88; 
		siz = 7;
		r = tempr;
		g = tempg;
		b = tempb;
	}
	public void die()
	{
		if(Math.random() < .3f)
		{
			siz -= Math.random()/150;
		}
	}
	public void show()
	{
		fill(r,g,b);
		stroke(r - 100, g - 100, b - 100);
		ellipse(x,y,siz,siz);
	}
	public void move()
	{
		int plusX, plusY;
		plusX = (int)(Math.random()*3)-1;
		plusY = (int)(Math.random()*3)-1;
		x += plusX;
		y += plusY;
	}
}  
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

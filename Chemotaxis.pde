Bacteria[] germ = new Bacteria[10];

void setup()   
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
void draw()   
{ 
	int i = 0;
	while(i < germ.length)
	{
		germ[i].die();
		germ[i].move();
		germ[i].show();
		if(germ[i].siz < 1.5)
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
	void die()
	{
		if(Math.random() < .3)
		{
			siz -= Math.random()/150;
		}
	}
	void show()
	{
		fill(r,g,b);
		stroke(r - 100, g - 100, b - 100);
		ellipse(x,y,siz,siz);
	}
	void move()
	{
		int plusX, plusY;
		plusX = (int)(Math.random()*3)-1;
		plusY = (int)(Math.random()*3)-1;
		x += plusX;
		y += plusY;
	}
}  

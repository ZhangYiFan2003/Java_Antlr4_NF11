package logogui;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Traceur {
	private static Traceur instance;
	private Group g;
	private Color c = Color.BLACK;
	private double initx = 350, inity = 350; 
	private double posx = initx, posy = inity; 
	private double angle = 90;
	private double teta;
	private boolean trace = true;
	ObjectProperty<GraphLineParameter> line;

	public Traceur() {
		setTeta();
		line = new SimpleObjectProperty<GraphLineParameter>();
	}
	
	public void setGraphics(Group g) {
		this.g = g;	
	}
	

	public ObjectProperty<GraphLineParameter> lineProperty() {
		return line;
	}

	private void setTeta() {
		teta = Math.toRadians(angle);
	}

	private void addLine(double x1, double y1, double x2, double y2) {
		line.setValue(new GraphLineParameter(x1, y1, x2, y2, c));
	}

	public void avance(int r) {
		double a = posx + r * Math.cos(teta);
		double b = posy - r * Math.sin(teta);
		addLine(posx, posy, a, b);

		posx = a;
		posy = b;
	}
	
	public void re(int r) {
		double a = posx - r * Math.cos(teta);
		double b = posy + r * Math.sin(teta);
		addLine(posx, posy, a, b);

		posx = a;
		posy = b;
	}

	public void td(int r) {
		angle = (angle - r) % 360;
		setTeta();
	}
	
	public void tg(int r) {
		angle = (angle + r) % 360;
		setTeta();
	}
	
	public void lc() {
		trace = false;
	}
	
	public void bc() {
		trace = true;
	}
	
	public void fcc(int r) {
		System.out.println(r);
		switch (r%8){
		case 0: c = Color.BLACK;break;
		case 1: c = Color.AQUA;break;
		case 2: c = Color.BEIGE;break;
		case 3: c = Color.CORAL;break;
		case 4: c = Color.FUCHSIA;break;
		case 5: c = Color.GOLD;break;
		case 6: c = Color.INDIGO;break;
		case 7: c = Color.OLIVE;break;
		}
	}
	
	public void fpos(double x, double y) {
		posx = x;
		posy = y;
	}


}

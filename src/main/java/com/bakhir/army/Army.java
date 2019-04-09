package com.bakhir.army;
import com.bakhir.army.models.weapon.*;
import javax.xml.bind.annotation.*;
@XmlRootElement(name = "army")
@XmlAccessorType(XmlAccessType.FIELD)
public class Army {
	@XmlElement(name = "zrk")
	private ZRK zrk;
	@XmlElement(name = "plane")
	private Plane plane;
	@XmlElement(name = "tank")
	private Tank tank;
	
	public Army() {		
	}
	public ZRK getZrk() {
		return zrk;
	}
	public void setZrk(ZRK zrk) {
		this.zrk = zrk;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	public Tank getTank() {
		return tank;
	}
	public void setTank(Tank tank) {
		this.tank = tank;
	}
	@Override
	public String toString() {
		return "Army [zrk=" + zrk + ", plane=" + plane + ", tank=" + tank + "]";
	}
	
}

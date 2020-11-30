package exercise9;

public class Ellipse {
  private Point startPoint;
  private double a;
  private double b;

  public Ellipse(){
    this.startPoint = new Point(0,0);
    this.a = 1;
    this.b = 1;
  }

  public Ellipse(Point startPoint, double a, double b){
    this.startPoint = new Point(startPoint);
    this.a = a;
    this.b = b;
  }

  public Ellipse (Ellipse otherEllipse){
    this.startPoint = new Point(otherEllipse.startPoint);
    this.a = otherEllipse.a;
    this.b = otherEllipse.b;
  }

  public boolean isValid(){
    return a>0 && b>0;
  }

  public void initialize(){
     do {
            System.out.println("Start point: ");
            startPoint.initialize();
            System.out.print("Enter height: ");
            this.a = Utils.INPUT.nextDouble();
            System.out.print("Enter width: ");
            this.b = Utils.INPUT.nextDouble();
        } while (!isValid());
  }

   public double calculatePerimeter(){
     return Math.PI*(3*(a+b)-Math.sqrt((3*a+b)+(a+3*b))); 

   }
   public double calculateArea(){
     return Math.PI*a*b; 
   } 

   public String getType(){
     return (Utils.equals(a,b)) ? "Cycle" : "Ellipse"; 
   }

   public String toString(){
     return String.format("%s-[%s,%s], P =%s, A = %s", startPoint, a, b, calculatePerimeter(), calculateArea());
   }
  
  public boolean equals(Ellipse otherEllipse){
    boolean sameHeight = Utils.equals(this.a,otherEllipse.a);
    boolean sameWidth = Utils.equals(this.b,otherEllipse.b);
    boolean sameHeightReversed = Utils.equals(this.a,otherEllipse.b);
    boolean sameWidthReversed = Utils.equals(this.b,otherEllipse.a);

    return (sameHeight && sameWidth) || (sameHeightReversed && sameWidthReversed);

  }




}
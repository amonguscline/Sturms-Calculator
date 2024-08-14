class Interval{
  private double max;
  private double min;
  private double midpoint;
  private Sturm sturm;
  public Interval(double min, dobule max){
    this.max=max;
    this.min=min;
    midpoint = min+(max-min)/2
  }
  public void makeSturm(Equation e){
    strum = new Sturm(e, this);
  }
  public int getNumOfRoots(){
    return strum.getNumOfRoots();
  }
  public int getRange(){
    return max-min;
  }
  public int getMidpoint(){
    return midpoint;
  }
  public Interval[] subDivide(){
    return {new Interval(min,midpoint), new Interval(midpoint,max)};
  }
}
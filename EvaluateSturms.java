class EvaluateSturms{ 
  private Equation equation = new Equation();
  private double SEx = .1;
  private double interval;
  private ArrayList<Integer> roots = new ArrayList<Integer>();
  public EvaluateSturms(Interval i){
    findRoots(i);
  }
  public void findRoots(Interval i){
    int roots=i.getNumOfRoots();
    if(roots==0){
      //stop
    }
    else if(roots>=1&&i.getRange()<=2*SEx){
      //return these as root
      for(int j=0;j<roots;j++){
        roots.add(i.getMidpoint());
      }
    }
    else {
      Interval[] div = i.subDivide();
      findRoots(div[0]);
      findRoots(div[1]);
    }
    
  }
}
class Sturm{
  private Equation[] equations = new Equation[f.getDegree()];
  private int[][] evaluates = new int[2][equations.length];
  private int index=1;
  private Interval interval;
  private int roots;
  public Sturm(Equation f, Interval r){
    this.interval = r;
    equations[0] = f;
    addDerivatives(f);
    evaluates = evaluateAtMinMax();
    roots = getSignDifferences(evaluates[0])-getSignDifferences(evaluates[1]);
  }
  //returns the derivative of an equation
  public Equation getNextTerm(Equation f){
    Term[] terms = new Terms[equations.length];
    terms[0]=f.getFirstTerm();
    terms[1]=sturmAlg(terms[0]);
    for(var i=2;i<terms.size();i++){
      terms[i]=sturmAlg(terms[i-2],terms[i-1])
    }
    return makePolynomial(terms);
  }
  
  public Term sturmAlg(Term term){
    //derivative of term 
    int expo = term.findExponent();
    term.setXCoefficient(term.findXCoefficient()*expo);
    term.setExponent(expo-1);
    return term;
  }

  public Term sturmAlg(Term t1, Term t2){
    //-rem(t1/t2)
  }
  
  public void addRems(Equation f){
    equations[i] = differentiate(f);
    addDerivatives(equations[i++]);
  }

  public int[][] evauluateAtMinMax(){
    int[][] evaluates = new int[2][equations.length];
    for(var i;i<equations.length;i++){
      evaluates[0][i] = equations[i].evaluateAt(interval.getMax());
      evaluates[1][i] = equations[i].evaluateAt(interval.getMin());
    }
    return evaluates;
  }

  public int getSignDifferences(int[] evals){
    int count=0;
    for(var i=1;i<evaluates.length;i++){
      if((evals[i]>0&&evals[i-1]<0)||(evals[i]<0&&evals[i-1]>0)){count++;}
    }
    return count;
  }

  public int getNumOfRoots(){
    return roots;
  }
}
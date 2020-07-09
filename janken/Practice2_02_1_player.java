import java.util.Random;

class Practice2_02_1_player{
	
	//-------フィールド------
	private String name ;
	private String handStatus ;
	
	//-------コンストラクタ--------
	Practice2_02_1_player( String nm ){
		this.name = nm ;
	}
	
	//-------メソッド---------
	public void makeHandStatus(){
		String[] makeHands = { "グー","チョキ","パー" };
		
		Random rnd = new Random();
		this.handStatus = makeHands[rnd.nextInt(3)] ;
	}
	
	//-------getter/setter--------
	
	public String getName(){
		return this.name ;
	}
	public void setName(){
		this.name = name ;
	}
	
	public String getHandStatus(){
		return this.handStatus ;
	}
	public void setHandStatus(){
		this.handStatus = handStatus ;
	}
	
}


class Cakeshop{
	public static void main(String[] args){
		int cake = 0 ; //cakeの初期化
		int sum = 0 ; //sumの初期化
		int each_price = 0 ; //each_priceの初期化
		
		for( int i = 0 ; i < args.length/2 ; i++ ){
			
			if( args[2*i].equals("ショートケーキ") ){
				cake = 320 ;
			}else if( args[2*i].equals("モンブラン") ){
				cake = 350 ;
			}else if( args[2*i].equals("チョコレートケーキ") ){
				cake = 370 ;
			}else if( args[2*i].equals("いちごのタルト") ){
				cake = 400 ;
			}else{
				cake = 300 ;
			}
			
			each_price = cake * Integer.parseInt(args[2*i+1]) ;
			sum = sum + each_price ;
		}
		
		System.out.println( "合計金額は" + sum + "円です。" ) ;
	}
}



class Cakeshop{
	public static void main(String[] args){
		int cake = 0 ; //cake�̏�����
		int sum = 0 ; //sum�̏�����
		int each_price = 0 ; //each_price�̏�����
		
		for( int i = 0 ; i < args.length/2 ; i++ ){
			
			if( args[2*i].equals("�V���[�g�P�[�L") ){
				cake = 320 ;
			}else if( args[2*i].equals("�����u����") ){
				cake = 350 ;
			}else if( args[2*i].equals("�`���R���[�g�P�[�L") ){
				cake = 370 ;
			}else if( args[2*i].equals("�������̃^���g") ){
				cake = 400 ;
			}else{
				cake = 300 ;
			}
			
			each_price = cake * Integer.parseInt(args[2*i+1]) ;
			sum = sum + each_price ;
		}
		
		System.out.println( "���v���z��" + sum + "�~�ł��B" ) ;
	}
}



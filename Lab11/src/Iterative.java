public class Iterative {

	public static BitList complement( BitList in ) {
		BitList result = new BitList();
		Iterator list = in.iterator();
		Iterator itr = result.iterator();
		
		while(list.hasNext()) {
			int bit = list.next();
			if(bit == BitList.ZERO)
				itr.add(BitList.ONE);
			if(bit == BitList.ONE)
				itr.add(BitList.ZERO);
		}
		return result;	
	}

	public static BitList or( BitList a, BitList b ) {
		BitList result = new BitList();
		Iterator a1 = a.iterator();
		Iterator b1 = b.iterator();
		if(!a1.hasNext())
			throw new IllegalArgumentException();
		if(!b1.hasNext())
			throw new IllegalArgumentException();
		Iterator itr = result.iterator();
		while(a1.hasNext()) {
			if(!b1.hasNext())
				throw new IllegalArgumentException();
			int bit = a1.next();
			int bit2 = b1.next();
			if(bit == BitList.ZERO && bit2 == BitList.ZERO)
				itr.add(BitList.ZERO);
			else
				itr.add(BitList.ONE);
		}
		if(b1.hasNext())
			throw new IllegalArgumentException();
		return result;
		
	}

	public static BitList and( BitList a, BitList b ) {
		BitList result = new BitList();
		Iterator a1 = a.iterator();
		Iterator b1 = b.iterator();
		if(!a1.hasNext())
			throw new IllegalArgumentException();
		if(!b1.hasNext())
			throw new IllegalArgumentException();
		Iterator itr = result.iterator();
		while(a1.hasNext()) {
			if(!b1.hasNext())
				throw new IllegalArgumentException();
			int bit = a1.next();
			int bit2 = b1.next();
			if(bit == BitList.ONE && bit2 == BitList.ONE)
				itr.add(BitList.ONE);
			else
				itr.add(BitList.ZERO);
		}
		if(b1.hasNext())
			throw new IllegalArgumentException();
		return result;
	}

	public static BitList xor( BitList a, BitList b ) {
		BitList result = new BitList();
		Iterator a1 = a.iterator();
		Iterator b1 = b.iterator();
		if(!a1.hasNext())
			throw new IllegalArgumentException();
		if(!b1.hasNext())
			throw new IllegalArgumentException();
		Iterator itr = result.iterator();
		while(a1.hasNext()) {
			if(!b1.hasNext())
				throw new IllegalArgumentException();
			int bit = a1.next();
			int bit2 = b1.next();
			if((bit == BitList.ZERO && bit2 == BitList.ZERO) || (bit == BitList.ONE && bit2 == BitList.ONE))
				itr.add(BitList.ZERO);
			else
				itr.add(BitList.ONE);
		}
		if(b1.hasNext())
			throw new IllegalArgumentException();
		return result;
	}
}
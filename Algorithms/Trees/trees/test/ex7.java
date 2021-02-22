package trees.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import trees.exercises.ex7.Pair;


class ex7 {

	List<Character> projects;
	List<Pair<Character,Character>> dependencies;
	
	private void getInputs(){
		trees.exercises.ex7 x = new trees.exercises.ex7();
		this.projects = new ArrayList<>(Arrays.asList('a','b','c','d', 'e', 'f')) ;
		this.dependencies = new ArrayList<>(
				Arrays.asList( 
						x.new Pair<Character, Character>('a', 'd'), 
						x.new Pair<Character, Character>('f', 'b'),
						x.new Pair<Character, Character>('b', 'd'),
						x.new Pair<Character, Character>('f', 'a'),
						x.new Pair<Character, Character>('d', 'c')
						));
	}
	
	private Map<Character, List<Character>> getDependenciesMap(){
		Map<Character, List<Character>> map = new HashMap<>();
		List<Character> list = new ArrayList<Character>();
		
		for(Pair<Character, Character> pair: dependencies) {
			if( map.containsKey(pair.second) ){
				list = map.get(pair.second); 
			}
			list.add(pair.first);
		}
		
		return map;
	}
	
	@Test
	void test() {
		Set<Character> set = trees.exercises.ex7.buildOrder(projects, dependencies);
		
	}

}

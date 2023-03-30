package com.student.management;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Subject{

	private String name;
	private Map<Student,Integer> results;
	public Subject(String name, Map<Student, Integer> results) {
		super();
		this.name = name;
		this.results = results;
	}
	public Subject() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Student, Integer> getResults() {
		return results;
	}
	public void setResults(Map<Student, Integer> results) {
		this.results = results;
	}
	public Map<Student, Integer> getSortedResults(){
        List<Map.Entry<Student, Integer> > list =
                new LinkedList<Map.Entry<Student, Integer> >(results.entrySet());
         Collections.sort(list, new Comparator<Map.Entry<Student, Integer> >() {
             public int compare(Map.Entry<Student, Integer> o1,
                                Map.Entry<Student, Integer> o2)
             {
                 return (o2.getValue()).compareTo(o1.getValue());
             }
         });
         HashMap<Student, Integer> temp = new LinkedHashMap<Student, Integer>();
         for (Map.Entry<Student, Integer> aa : list) {
             temp.put(aa.getKey(), aa.getValue());
         }
         return temp;
	}
}

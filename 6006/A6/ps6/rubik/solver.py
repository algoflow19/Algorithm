import rubik
  
# Let each operator being dict[(perm_seq)]=([op_seq])

def convertStrStoreToAnswerList(store):
  return [eval('rubik.'+op) for op in store]

def shortest_path(start, end):
    """
    Using 2-way BFS, finds the shortest path from start_position to
    end_position. Returns a list of moves. 

    You can use the rubik.quarter_twists move set.
    Each move can be applied using rubik.perm_apply
    """
    if(start==end): return []
    start_set={start:[]}
    end_set={end:[]}
    for i in range(7):
      new_start_set={}
      new_end_set={}
#     do new step
      for pos in start_set:
        last_op_seq=start_set[pos]
        for perm in rubik.quarter_twists:
          new_pos=rubik.perm_apply(perm,pos)
          if(new_start_set.get(new_pos) == None):
            new_start_set[new_pos]=last_op_seq+[rubik.quarter_twists_names[perm]]
#     check key
      for pos in end_set.keys():
        if(new_start_set.get(pos)!=None):
          first_part_answer=convertStrStoreToAnswerList(new_start_set[pos])
          second_part_answer=convertStrStoreToAnswerList(end_set[pos])
          second_part_answer.reverse()
          second_part_answer=[rubik.perm_inverse(p) for p in second_part_answer]
          return first_part_answer+second_part_answer
#      do new step
      for pos in end_set:
        last_op_seq=end_set[pos]
        for perm in rubik.quarter_twists:
          new_pos=rubik.perm_apply(perm,pos)
          if(new_end_set.get(new_pos)==None):
            new_end_set[new_pos]=last_op_seq+[rubik.quarter_twists_names[perm]]
      start_set=new_start_set
      for pos in start_set.keys():
        if(new_end_set.get(pos)!=None):
          first_part_answer=convertStrStoreToAnswerList(new_start_set[pos])
          second_part_answer=convertStrStoreToAnswerList(new_end_set[pos])
          second_part_answer.reverse()
          second_part_answer=[rubik.perm_inverse(p) for p in second_part_answer]
          return first_part_answer+second_part_answer
      end_set=new_end_set
    return None
#
#k=rubik.I
#k=rubik.perm_apply(rubik.F,k)
#reverse_F=rubik.perm_inverse(rubik.F)
#k=rubik.perm_apply(reverse_F,k)
#print(k)
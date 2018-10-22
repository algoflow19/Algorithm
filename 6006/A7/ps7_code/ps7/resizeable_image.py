import imagematrix
import sys

class ResizeableImage(imagematrix.ImageMatrix):
    def best_seam(self):
      energy={}
      for i in range(0,self.width):
        for j in range(0,self.height):
          energy[i,j]=self.energy(i,j)
      dp={}
      for i in range(0,self.width):
        dp[i,0]=energy[i,0]
      
      for j in range(1,self.height):
        dp[0,j]=min(dp[0,j-1],dp[1,j-1])+energy[0,j]
        dp[self.width-1,j]=min(dp[self.width-1,j-1],dp[self.width-2,j-1])+energy[self.width-1,j]
        for i in range(1,self.width-1):
          dp[i,j]=min(dp[i,j-1],dp[i-1,j-1],dp[i+1,j-1]) + energy[i,j]
      choose=0
      last_j=self.height-1
      cheapest=dp[0,last_j]
      for i in range(1,self.width):
        cost=dp[i,last_j]
        if(cost<cheapest):
          choose=i
          cheapest=cost
      track=[]
      track.append((choose,last_j))
      for j in range(last_j,0,-1):
        choose=choose-1
        cost=0
        d2cost=0
        shift=0
        if(choose!=-1):
          cost=dp[choose,j-1]
        else: cost=sys.maxsize
        d_1=dp[choose+1,j-1]
        d_2=0
        
        try:
          d_2=dp[choose+2,j-1]
        except:
          d_2=sys.maxsize
        
        if(d_1 < d_2):
          shift=1
          d2cost=d_1
        else:
          shift=2
          d2cost=d_2
        if(d2cost<cost):
          choose+=shift
        track.append((choose,j-1))
      track.reverse()
      return track
    def remove_best_seam(self):
        self.remove_seam(self.best_seam())

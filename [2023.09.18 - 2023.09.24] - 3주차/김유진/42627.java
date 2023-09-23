import java.util.*;

class Job implements Comparable<Job>{
    int inTime;
    int runningTime;
    
    public Job(int inTime, int runningTime){
        this.inTime=inTime;
        this.runningTime=runningTime;
    }
    
    //runningTime 오름차순 + 같은 경우엔 먼저 들어온 아이를 우선으로 
    public int compareTo(Job j){
        if(this.runningTime<j.runningTime)
            return -1;
        else if(this.runningTime==j.runningTime)
            return this.inTime-j.inTime;
        else
            return 1;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        
        LinkedList<Job>[] jobAtTime=new LinkedList[1000+1];
        for(int i=0;i<=1000;i++){
            jobAtTime[i]=new LinkedList<Job>();
        }
        
        for(int[] job:jobs){
            int start=job[0]; int running=job[1];
            
            jobAtTime[start].add(new Job(start, running));
        }
        
        int execute=0; int time=0; int allTimeForJob=0;
        Job nowJob=null;
        
        PriorityQueue<Job> queue=new PriorityQueue<>();
        
        while(true){
            //0. 이전까지 진행하던 작업이 끝난 경우 처리
            if(nowJob!=null && nowJob.runningTime==0){
                execute++;
                //현재 시간과 들어온 시간을 빼서 
                allTimeForJob+=time-nowJob.inTime;
                    
                nowJob=null;
            }
            
            //0-1. 끝난 작업으로 모든 작업이 완료되는 경우
            if(execute==jobs.length)
                break;
            
            if(time<=1000){
                //1. 현재 time에 들어온 작업 우선순위 큐에 추가 
                for(Job j: jobAtTime[time]){
                    queue.add(j);
                }
            }
            
            //2-1. 현재 진행중인 작업이 없을 때
            if(nowJob==null){
                //2-1-1. 큐에 들어온 작업이 있으면 
                if(!queue.isEmpty()){
                    nowJob=queue.poll();
                }
            }
            
            //2-2. 현재 진행중인 작업이 있을 때
            if(nowJob!=null)
                nowJob.runningTime-=1;
            
            time++;
        }
        
        return allTimeForJob / jobs.length;
    }
}

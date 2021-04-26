package main.greedy;

import java.util.ArrayList;

public class JobSequencingProblem {

    char id;
    int deadline, profit;

    // Constructors
    public JobSequencingProblem() {
    }

    public JobSequencingProblem(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public void sortJobScheduling(ArrayList<JobSequencingProblem> arr, int t){

        for(int i = 0; i < arr.size(); i++)
        {
            for(int j = 0; j < arr.size() - 1 - i; j++)
            {
                if (arr.get(j).profit <
                        arr.get(j + 1).profit)
                {
                    JobSequencingProblem temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }

        char job[] = new char[t];
        boolean result[] = new boolean[t];

        for(int i=0; i<arr.size(); i++){

            for(int j = Math.min(t - 1, arr.get(i).deadline - 1);
                j >= 0; j--){

                if (result[j] == false)
                {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }

        for(char jb: job)
        {
            System.out.print(jb + " ");
        }
        System.out.println();
    }


    public static void main(String args[])
    {
        ArrayList<JobSequencingProblem> arr = new ArrayList<JobSequencingProblem>();

        arr.add(new JobSequencingProblem('a', 2, 100));
        arr.add(new JobSequencingProblem('b', 1, 19));
        arr.add(new JobSequencingProblem('c', 2, 27));
        arr.add(new JobSequencingProblem('d', 1, 25));
        arr.add(new JobSequencingProblem('e', 3, 15));

        System.out.println("Following is maximum " +
                "profit sequence of jobs");

        JobSequencingProblem job = new JobSequencingProblem();

        // Calling function
        job.sortJobScheduling(arr, 3);
    }
}


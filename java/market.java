import java.util.Arrays;
import java.util.Scanner;


public class market{
    public  static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] nums=null;
        System.out.println("请输入A，以空格分隔：");
        nums=sc.nextLine().split(" ");
        int A[]=new int[nums.length];
		for(int i=0;i<nums.length;i++)
			A[i]=Integer.valueOf(nums[i]);
		System.out.println("请输入B，以空格分隔：");
        nums=sc.nextLine().split(" ");
        int B[]=new int[nums.length];
		for(int i=0;i<nums.length;i++)
			B[i]=Integer.valueOf(nums[i]);
		int length=A.length;
        double cost=0;
        int[] a=new int [length];int numa=0;
        int[] b=new int [length];int numb=0;
        int[][] c=new int [2][length];int numc=0;
        for(int i=0;i<length;i++)
        {
            if(A[i]<B[i]*0.5)
            {
                a[numa++]=A[i];

            }
            else if(A[i]*0.6>B[i])
            {
                b[length-1-numb]=B[i];
                numb++;
            }
            else 
            {
                c[0][numc]=A[i];
                c[1][numc++]=B[i];
            }  
            int tempa=0;
            int tempb=0;
            for(int j=0;j<numc-1;j++)
           for(int n=j;n<numc-1;n++)  
           {
            if(c[1][n]>c[1][n+1])
            {
                tempa=c[0][n];c[0][n]=c[0][n+1];c[0][n+1]=tempa;
                tempb=c[1][n];c[1][n]=c[1][n+1];c[1][n+1]=tempb;

            }
           }     
        }
        double suma=sumA(a,numa);
        double suma2,suma1,sumae;
        int sumb2,sumb1,sumbe;
        int sumb=sumB(b,numb);
        if(numc>0){

        //     System.out.println("此时：b="+sumb);
        //     for(int endbt:b)
        // {
        //     System.out.print(endbt+" ");
        // }
        // System.out.println();
        // for(int[] endbc:c)
        //     for(int t:endbc)
        // {
        //     System.out.print(t+" ");
        // }
        // System.out.println();
        
        if(numb%2==0)
        {
            for(int cc=numc;cc>1;cc=cc-2)
            {
                suma2=sumA2(a,numa,c[0][cc-1],c[0][cc-2]);
                sumb2=sumB2(b,numb,c[1][cc-1],c[1][cc-2]);
                if(sumb+suma2>suma+sumb2)
                {
                    b[length-1-numb]=c[1][cc-2];
                    b[length-2-numb]=c[1][cc-1];
                    sumb=sumb2;
                    numb+=2;

                }
                else
                {
                    a[numa]=c[0][cc-2];
                    a[numa+1]=c[0][cc-1];
                    suma=suma2;
                    numa+=2;
                }
            }
            if(numc%2==1)
            {
                suma1=sumA1(a,numa,c[0][0]);
                sumb1=sumB1(b,numb,c[1][0]);
                if(sumb+suma1>suma+sumb1)
                {
                    b[length-1-numb]=c[1][0];
                    numb++;
                    sumb=sumb1;
                }
                else
                {
                    a[numa++]=c[0][0];
                    suma=suma1;
                }


            }
            
        }
        else
        {
            sumae=sumA1(a,numa,c[0][numc-1]);
            sumbe=sumB1(b,numb,c[1][numc-1]);
            if(sumae+sumb>suma+sumbe)
            {
                b[length-1-numb]=c[1][numc-1];numb++;
                sumb=sumbe;

            }
            else
            {
                a[numa++]=c[0][numc-1];
                suma=sumae;
            }
            for(int cc=numc;cc>1;cc=cc-2)
            {
                suma2=sumA2(a,numa,c[0][cc-1],c[0][cc-2]);
                sumb2=sumB2(b,numb,c[1][cc-1],c[1][cc-2]);
                if(sumb+suma2>suma+sumb2)
                {
                    b[length-1-numb]=c[1][cc-2];
                    b[length-2-numb]=c[1][cc-1];
                    sumb=sumb2;
                    numb+=2;

                }
                else
                {
                    a[numa]=c[0][cc-2];
                    a[numa+1]=c[0][cc-1];
                    suma=suma2;
                    numa+=2;
                }
            }
            if(numc%2==0)
            {
                suma1=sumA1(a,numa,c[0][0]);
                sumb1=sumB1(b,numb,c[1][0]);
                if(sumb+suma1>suma+sumb1)
                {
                    b[length-1-numb]=c[1][0];numb++;
                    sumb=sumb1;
                }
                else
                {
                    a[numa++]=c[0][0];
                    suma=suma1;
                }


            }
        }
    }
    //     if(numc%2==1)
    //     {
    //     for(int m=numc-1;m>0;m=m-2)
    //     {
    //         if(c[1][m]>=c[0][m]*c[0][m-1]*0.6)
    //         {
    //             a[numa++]=c[0][m];
    //             a[numa++]=c[0][m-1];

    //         }
    //         else
    //         {
    //             b[numb++]=c[1][m];
    //             b[numb++]=c[1][m-1];
    //         }
           
            
    //     }
    //     if(numa>=2&&numb%2==0)
    //     {
    //         if(c[0][0]*0.6>c[1][0])
    //         b[numb++]=c[1][0];
    //         else
    //         a[numa++]=c[1][0];
    //     }
    //     else if(numa>=2&&numb%2==1)
    //     {
    //         if(c[0][0]*0.6>c[1][0])
    //         b[numb++]=c[1][0];
    //         else
    //         a[numa++]=c[1][0];
    //     }

    // }
    //     else
    //     for(int m=numc-1;m>0;m=m-2)
    //     {
    //         if(c[1][m]>=c[0][m]*c[0][m-1]*0.6)
    //         {
    //             a[numa++]=c[0][m];
    //             a[numa++]=c[0][m-1];
    //         }
    //         else
    //         {
    //             b[numb++]=c[1][m];
    //             b[numb++]=c[1][m-1];
    //         }
           
            
    //     }
    //
    //
        //output
        // for(int[] r:c)
        // {
        //     for(int l:r)
        //     {
        //         System.out.print(l+" ");
        //     }
        //     System.out.println(); 
        // }
        // for(int enda:a)
        // {
        //     System.out.print(enda+" ");
        // }
        // System.out.println();
        // for(int endb:b)
        // {
        //     System.out.print(endb+" ");
        // }
        // System.out.println();
        cost=suma+sumb;
        
        // System.out.print(suma+" ");
        // System.out.print(sumb+" ");
        System.out.print(cost+" ");
    } 
public static double sumA(int[] price,int lengtha)
{
    double sum=0;
    int length =lengtha;
    for(int i=0;i<length;i++)
    {
        sum+=price[i];
        }
    if(length>=3)
    {
        sum*=0.6;

    }
    return sum;
}
public static double sumA1(int[] price,int lengtha,int add)
{
    double sum=0;
    int length =lengtha;
    for(int i=0;i<length;i++)
    {
        sum+=price[i];
        }
        sum+=add;
    if(length>=2)
    {
        sum*=0.6;

    }
    return sum;
}
public static double sumA2(int[] price,int lengtha,int add1,int add2)
{
    double sum=0;
    int length =lengtha;
    for(int i=0;i<length;i++)
    {
        sum+=price[i];
        }
        sum+=add1;
        sum+=add2;
    if(length>=1)
    {
        sum*=0.6;

    }
    return sum;
}
public static int sumB(int[] price,int numb)
{
    int l=numb;
    int length=price.length;
    Arrays.sort(price);
    int sum=0;
    if(l%2==0)
    {
        for(int i=1;i<l;i=i+2)
        {
            sum+=price[length-i];

        }
    }
    else
    {
         for(int i=0;i<l;i=i+2)
        {
            sum+=price[length-1-i];

        }
    }
    return sum;
}
public static int sumB1(int[] price,int numb,int add)
{
    int l=numb;
    int length=price.length;
    int[] copyp=new int[l+1];
    for(int k=0;k<l;k++)
    {
        copyp[k]=price[length-1-k];
    }
    copyp[l]=add;
    Arrays.sort(copyp);
    int sum=0;
    if(l%2==1)
    {
        for(int i=0;i<l+1;i=i+2)
        {
            sum+=copyp[i+1];

        }
    }
    else
    {
         for(int i=0;i<l+1;i=i+2)
        {
            sum+=copyp[i];

        }
    }
    return sum;
}
public static int sumB2(int[] price,int numb,int add1,int add2)
{
    int l=numb;
    int length=price.length;
    int[] cp=new int[l+2];
    for(int k=0;k<l;k++)
    {
        cp[k]=price[length-1-k];
    }
    cp[l]=add1;
    cp[l+1]=add2;
    Arrays.sort(cp);
    int sum=0;
    if(l%2==0)
    {
        for(int i=0;i<l+2;i=i+2)
        {
            sum+=cp[i+1];

        }
    }
    else
    {
         for(int i=0;i<l+2;i=i+2)
        {
            sum+=cp[i];

        }
    }
    return sum;
}
//
}


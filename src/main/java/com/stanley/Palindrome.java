package com.stanley;

public class Palindrome {

    public String longest(String p)
    {
        int[][] r = new int[p.length()][p.length()];
        int maxStart=-1,maxEnd=-1;


        for(int s =p.length()-1;s>=0;s--)
        {
            for( int e=p.length()-1;e>=s;e--)
            {
                if(s==e)
                {
                    r[s][e]=1;
                    if(maxEnd<0)
                    //if(maxEnd-maxStart<e-s)
                    {
                        maxStart=s;
                        maxEnd=e;
                    }
                }
                else if(p.charAt(s)==p.charAt(e))
                {
                    if(e-s==1)
                    {
                        r[s][e]=1;
                        if(maxEnd-maxStart<e-s)
                        {
                            maxStart=s;
                            maxEnd=e;
                        }

                    }
                    else
                    {
                        r[s][e]=r[s+1][e-1];
                        if(maxEnd-maxStart<e-s)
                        {
                            maxStart=s;
                            maxEnd=e;
                        }

                    }
                }
                else
                {
                    r[s][e]=0;
                }
            }
        }


        return p.substring(maxStart,maxEnd+1);
    }

//    public String longestxx(String p)
//    {
//        int[][] r = new int[p.length()][p.length()];
//        int maxStart=0,maxEnd=-1;
//
//
//        for(int s =0;s<p.length();s++)
//        {
//            for( int e=0;e<=s;e++)
//            {
//                if(s==e)
//                {
//                    r[s][e]=1;
//                    if(maxEnd-maxStart<e-s)
//                    {
//                        maxStart=s;
//                        maxEnd=e;
//                    }
//                }
//                else if(p.charAt(s)==p.charAt(e))
//                {
//                    if(e-s==1)
//                    {
//                        r[s][e]=1;
//                        if(maxEnd-maxStart<e-s)
//                        {
//                            maxStart=s;
//                            maxEnd=e;
//                        }
//
//                    }
//                    else
//                    {
//                        r[s][e]=r[s+1][e-1];
//                        if(maxEnd-maxStart<e-s)
//                        {
//                            maxStart=s;
//                            maxEnd=e;
//                        }
//
//                    }
//                }
//                else
//                {
//                    r[s][e]=0;
//                }
//            }
//        }
//
//
//        return p.substring(maxStart,maxEnd+1);
//    }



}

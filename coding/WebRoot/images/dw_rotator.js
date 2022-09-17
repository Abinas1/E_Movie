/*************************************************************************
    This code is from Dynamic Web Coding at dyn-web.com
    Copyright 2001-5 by Sharon Paine 
    See Terms of Use at www.dyn-web.com/bus/terms.html
    regarding conditions under which you may use this code.
    This notice must be retained in the code as is!
*************************************************************************/

/*  Readable code available for licensed users */

dw_Rotator.restartDelay = 500; // delay onmouseout before call to rotate
dw_Rotator.col=[];
//function dw_Rotator(name,speed,path,tgt)

function dw_Rotator(speed,tgt)
{
    this.name=name;
    //this.path=path||"";
    this.tgt=tgt;
    this.ctr=0;
    this.imgs=[];
    this.actions=[];
    
    this.speed=speed||4500;
    
    
    this.timer=0;
    
    
    this.index=dw_Rotator.col.length;
    dw_Rotator.col[this.index]=this;
    this.animString="dw_Rotator.col["+this.index+"]";
};
//dw_Rotator.prototype.addImages=function()
//                                {
//                                    var img;
//                                    for(var i=0;arguments[i];i++)
//                                    {
//                                        img=new Image();
//                                        img.src=this.path+arguments[i];
//                                        this.imgs[this.imgs.length]=img;
//                                    }
//                                };
//dw_Rotator.prototype.addActions=function()
//                                {
//                                    var len=arguments.length;
//                                    for(var i=0;i<len;i++)
//                                        this.actions[this.actions.length]=arguments[i];
//                                };
dw_Rotator.prototype.rotate=function(n)
                            {
                                clearTimeout(this.timer);
                                this.timer=null;
//                                if(this.ctr<this.imgs.length-1)
//                                    this.ctr++;
//                                else 
//                                    this.ctr=0;
                                //var imgObj=document.images[this.name];
                                //if(imgObj&&dw_Rotator.ready)
                             //   if(dw_Rotator.ready)
                                {   
                                    //imgObj.src=this.imgs[this.ctr].src;
                                    //////////////////////////////////////////
                                    if(n==0)
                                        MoveNext_FirstCut()
                                        //MoveNext_NowShowing();
                                    else if(n==1)
                                        MoveNext_ComingSoon();
                                    //////////////////////////////////////////
                                    this.timer=setTimeout(this.animString+".rotate("+n+")",this.speed);
                                }
                            };
dw_Rotator.start=function()
                {
                    var len=dw_Rotator.col.length,obj;
                    for(var i=0;i<len;i++)
                    {
                        obj=dw_Rotator.col[i];
                        //if(obj&&obj.name)
                        if(obj)
                            obj.timer=setTimeout(obj.animString+".rotate("+i+")",obj.speed);
                    }
                };
//dw_Rotator.doClick=function(n)
//                    {
//                        var obj=dw_Rotator.col[n];
//                        if(!document.images||!obj)
//                            return true;
//                        if(obj.actions&&obj.actions[obj.ctr])
//                        {
//                            if(typeof obj.actions[obj.ctr]=="string")
//                            {
//                                if(obj.tgt)
//                                {
//                                    var win=window.open(obj.actions[obj.ctr],obj.tgt);
//                                    if(win&&!win.closed)
//                                        win.focus();
//                                }
//                                else
//                                {
//                                    window.location=obj.actions[obj.ctr];
//                                }
//                            }
//                            else
//                            {
//                                obj.actions[obj.ctr]();
//                            }
//                        }
//                        return false;
//                    };
dw_Rotator.pause=function(n)
                {
                    dw_Rotator.clearTimers(n);
                };
dw_Rotator.clearTimers=function(n)
                        {
                            var obj=dw_Rotator.col[n];
                            if(obj)
                            {
                                clearTimeout(obj.timer);
                                obj.timer=null;
                            }
                        };
dw_Rotator.resume=function(n)
                {
                    dw_Rotator.clearTimers(n);
                    var obj=dw_Rotator.col[n];
                    if(obj)
                    {
                        obj.timer=setTimeout(obj.animString+".rotate("+n+")",dw_Rotator.restartDelay);
                    }
                };
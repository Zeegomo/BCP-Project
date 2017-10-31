import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.net.*;
import java.applet.* ;
import java.io.File;
import java.applet.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Progettojava extends JApplet implements ActionListener, MouseListener, KeyListener, MouseMotionListener
{
    AreaGrafica area;
    int  larghezza, altezza,spawnarmi,arma,h;
    boolean spawnarma,menu,impostazioni,scelta,scelta2,scelta1,on;
    Random k = new Random();
    URL base;
    MediaTracker mt;
    AudioClip piu,tunf,falsone;
    
    //primo giocatore
    int x,y,a,doppiosalto,rinculo1,caricatore1,direzione,b,arma1,munizioni1,knockback1,knockbackt1,r1s,r1d,reload1,w1,t1s,t1d,vita1,respawn1,supercolpo1;
    int dx,dy,xvirgilio,yvirgilio,virgiliox,virgilioy,ki,hitparade1,caccapupu1,gsupercolpo1,mov1,maledizione1,gallo1,gallettino1,personaggio1;
    float modulo;
    int[] xsparo1;
    int[] ysparo1;
    int[] shotgunx1;
    boolean[] direz;
    boolean sinistra,destra,fermo,alto,basso,sparo1,ricarica,morto1,caduto1,vittoria1; 
    boolean pistola1,shotgun1,rpg1,sniper1,assault1,hit1s,hit1d,hitt1d,hitt1s,ready1,scatola1;
    boolean dante1,cesare1,buonconte1,william1,galileo1,mose1;
    boolean abilita1,hitvirgilio1,stun1,galletto1;
    
    //secondo giocatore   
    int x2,y2,a2,doppiosalto2,rinculo2,caricatore2,direzione2,d,arma2,munizioni2,knockback2,knockbackt2,r2s,r2d,t2s,t2d,reload2,w2,vita2,respawn2,supercolpo2;
    int dx2,dy2,x2virgilio,y2virgilio,virgiliox2,virgilioy2,ki2,hitparade2,caccapupu2,gsupercolpo2,mov2,maledizione2,gallo2,gallettino2,personaggio2;
    float modulo2;
    int[] xsparo2;
    int[] ysparo2;
    int[] shotgunx2;
    boolean[] direz2;    
    boolean sinistra2,destra2,fermo2,alto2,basso2,sparo2,ricarica2,morto2,caduto2,vittoria2;    
    boolean pistola2,shotgun2,rpg2,sniper2,assault2,hit2s,hit2d,hitt2s,hitt2d,ready2,scatola2;
    boolean dante2,cesare2,buonconte2,william2,galileo2,mose2;
    boolean abilita2,hitvirgilio2,stun2,galletto2;
    
    Image dantemenu,mosemenu,williammenu,cesaremenu,galileomenu,buoncontemenu,dante,cesare,mose,galileo,william,dantes,cesares,moses,galileos,williams,sfondo;
    Image assalto,sniper,shotgun,pistola,assaltos,snipers,shotguns,pistolas,virgilio,virgilios,gioca,rpg,rpgs,buonconte,buoncontes,bcp,bcpp,boh,bohs;
    Image maledizione,roccia,comandi,rotella,selezione;
    // si va a berlino Beppe!
    Timer t; // temporizzatore
    public void init()
    { 
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        
        
        //posizioni iniziali
        x=341; y=0;
        x2=441;;y2=0;
        
        mt = new MediaTracker(this);
        try 
        {
            base = getDocumentBase();
        }
        catch (Exception e) {} 
        
         
        cesaremenu = getImage(base,"cesaremenu.gif");
        dantemenu = getImage(base,"dantemenu.gif");
        williammenu = getImage(base,"williammenu.gif");
        mosemenu = getImage(base,"mosemenu.gif");
        galileomenu = getImage(base,"galileomenu.gif");
        buoncontemenu = getImage(base,"buoncontemenu.gif");
        cesare = getImage(base,"cesare.gif");
        dante = getImage(base,"dante.gif");
        william = getImage(base,"wallace.gif");
        mose = getImage(base,"mose.gif");
        galileo = getImage(base,"galileo.gif");        
        cesares = getImage(base,"cesares.gif");
        dantes= getImage(base,"dantes.gif");
        williams = getImage(base,"wallaces.gif");
        moses = getImage(base,"moses.gif");
        galileos = getImage(base,"galileos.gif");
        sfondo = getImage(base,"sfondo.gif");
        pistola = getImage(base,"pistola.gif");
        sniper = getImage(base,"sniper.gif");
        shotgun = getImage(base,"shotgun.gif");
        assalto = getImage(base,"assalto.gif");
        pistolas = getImage(base,"pistolas.gif");
        snipers = getImage(base,"snipers.gif");
        shotguns = getImage(base,"shotguns.gif");
        assaltos = getImage(base,"assaltos.gif");
        virgilio = getImage(base,"virgilio.gif");
        virgilios = getImage(base,"virgilios.gif");
        buoncontes = getImage(base,"buoncontes.gif");
        buonconte = getImage(base,"buonconte.gif");
        rpg = getImage(base,"rpg.gif");
        rpgs = getImage(base,"rpgs.gif");
        gioca = getImage(base,"gioca.gif");
        bcp = getImage(base,"bcp.gif");
        bcpp = getImage(base,"bcpp.gif");
        boh = getImage(base,"boh.gif");
        bohs = getImage(base,"bohs.gif");
        maledizione = getImage(base,"maledizione.gif");
        roccia = getImage(base,"roccia.gif");
        comandi = getImage(base,"comandi.gif");
        rotella = getImage(base,"impostazioni.gif");
        selezione = getImage(base,"selezione.gif");
        
        mt.addImage(sfondo,1);
        mt.addImage(cesaremenu,1);
        mt.addImage(dantemenu,1);
        mt.addImage(mosemenu,1);
        mt.addImage(williammenu,1);
        mt.addImage(galileomenu,1);
        mt.addImage(cesare,1);
        mt.addImage(dante,1);
        mt.addImage(mose,1);
        mt.addImage(william,1);
        mt.addImage(galileo,1);
        mt.addImage(cesares,1);
        mt.addImage(dantes,1);
        mt.addImage(moses,1);
        mt.addImage(williams,1);
        mt.addImage(galileos,1);
        mt.addImage(pistola,1);
        mt.addImage(sniper,1);
        mt.addImage(shotgun,1);
        mt.addImage(assalto,1);
        mt.addImage(pistolas,1);
        mt.addImage(snipers,1);
        mt.addImage(shotguns,1);
        mt.addImage(assaltos,1);
        mt.addImage(buonconte,1);
        mt.addImage(buoncontes,1);
        mt.addImage(rpg,1);
        mt.addImage(rpgs,1);
        mt.addImage(gioca,1);
        mt.addImage(bcp,1);
        mt.addImage(bcpp,1);    
        mt.addImage(boh,1);    
        mt.addImage(bohs,1);    
        mt.addImage(maledizione,1); 
        mt.addImage(buoncontemenu,1);    
        mt.addImage(roccia,1); 
        mt.addImage(comandi,1); 
        mt.addImage(rotella,1); 
        mt.addImage(selezione,1); 
        
        tunf = getAudioClip(base,"tunf .wav");
        falsone = getAudioClip(base,"falsone .wav");
        piu = getAudioClip(base,"piu.wav");
      
      
      
        //variabili
      
        caricatore1=-1;
        caricatore2=-1;
        
        doppiosalto=0;
        
        a=14;
        a2=14;
        
        vita1=5;
        vita2=5;
        
        mov2=2;
        mov1=2;
        
        ki=6;
        ki2=6;
        
        knockback1=0;
        knockback2=0;
        
        
        
        ricarica=false;
        sinistra=false;
        destra=false;
        fermo=false; 
        ready1=true;
        ready2=true;
        menu=true;
        vittoria1=false;
        vittoria2=false;
        
      
        //vettori proiettili
        xsparo1 = new int[201];
        ysparo1 = new int[201];
        direz = new boolean[201];
        shotgunx1= new int[201];
      
        ysparo2 = new int[201];
        xsparo2 = new int[201];
        direz2 = new boolean[201];
        shotgunx2= new int[201];
      
        area=new AreaGrafica();
        this.setContentPane(area);
        this.setSize(782,440);
        this.requestFocusInWindow();
        this.setFocusable(true);
    }
      public void keyPressed( KeyEvent e ) 
    {
        
        if(scelta)
        {
            if( e.getKeyChar()=='w'){personaggio2++;if(personaggio2>5){personaggio2=0;}}
            if( e.getKeyChar()=='s'){personaggio2--;if(personaggio2<0){personaggio2=5;}}
            
            if( e.getKeyCode()==KeyEvent.VK_UP){personaggio1++;if(personaggio1>5){personaggio1=0;}}
            if( e.getKeyCode()==KeyEvent.VK_DOWN){personaggio1--;if(personaggio1<0){personaggio1=5;}}
            
            if( e.getKeyCode()==KeyEvent.VK_ENTER)
            {
                switch (personaggio1)
                {
                case 0: dante1=true;
                        william1=false;
                        buonconte1=false;
                        mose1=false;
                        cesare1=false;
                        galileo1=false;
                        scelta1=true;
                        
                        
                        break;
                        
                case 1: william1=true;
                        dante1=false;
                        buonconte1=false;
                        mose1=false;
                        cesare1=false;
                        galileo1=false;
                        scelta1=true;

                        break;
                        
                case 2: cesare1=true;
                        dante1=false;
                        william1=false;
                        buonconte1=false;
                        mose1=false;
                        galileo1=false;
                        scelta1=true;
                
                        break;
                        
                case 3: mose1=true;
                        dante1=false;
                        william1=false;
                        buonconte1=false;
                        cesare1=false;
                        galileo1=false;
                        scelta1=true;
                        
                        break;
                        
                case 4: buonconte1=true;
                        dante1=false;
                        william1=false;
                        mose1=false;
                        cesare1=false;
                        galileo1=false;
                        scelta1=true;
                        
                        break;
                        
                case 5: galileo1=true;
                        dante1=false;
                        william1=false;
                        mose1=false;
                        cesare1=false;
                        scelta1=true;
                        
                        break;
              }   
              
            }
            if(scelta)
            {
            
            
                switch (personaggio2)
                {
                 case 0:dante2=true;
                        william2=false;
                        buonconte2=false;
                        mose2=false;
                        cesare2=false;
                        galileo2=false;
                        scelta2=true;
                        
                        break;
                        
                 case 1:william2=true;
                        dante2=false;
                        buonconte2=false;
                        mose2=false;
                        cesare2=false;
                        galileo2=false;
                        scelta2=true;
                        
                        break;
                        
                 case 2:cesare2=true;
                        dante2=false;
                        william2=false;
                        buonconte2=false;
                        mose2=false;
                        galileo2=false;
                        scelta2=true;
                        
                        break;
                        
                 case 3:mose2=true;
                        dante2=false;
                        william2=false;
                        buonconte2=false;
                        cesare2=false;
                        galileo2=false;
                        scelta2=true;
                        
                        break;
                        
                 case 4:buonconte2=true;
                        dante2=false;
                        william2=false;
                        mose2=false;
                        cesare2=false;
                        galileo2=false;
                        scelta2=true;
                        
                        break;
                        
                 case 5:galileo2=true;
                        dante2=false;
                        william2=false;
                        buonconte2=false;
                        mose2=false;
                        cesare2=false;
                        scelta2=true;
                        
                        break;
            
                }
            }
              
            
            
        }
        
        if(!menu && !scelta && !impostazioni)
        {
            //primo giocatore
            if(!stun1)
            {
                if( e.getKeyCode()==KeyEvent.VK_UP && doppiosalto<2){alto=true;doppiosalto++;a=14;}
                if( e.getKeyCode()==KeyEvent.VK_LEFT ){sinistra=true;direzione=0;}
                if( e.getKeyCode()==KeyEvent.VK_DOWN){basso=true;}
                if( e.getKeyCode()==KeyEvent.VK_RIGHT ){destra=true;direzione=1;}
                if( e.getKeyChar()=='p')
                {
                    sparo1=true;
                    if(caricatore1<(munizioni1-1) && ready1 && !ricarica)
                    {
                        ready1=!ready1;
                        caricatore1++;
                        if(rpg1)
                        {
                            tunf.play();
                        }
                        else
                        {
                            piu.play();
                        }
                        xsparo1[caricatore1]=x;
                        ysparo1[caricatore1]=y+47;   
                        if(shotgun1)
                        {
                            shotgunx1[caricatore1]=x;
                        }
                        if(direzione==0)
                        {
                            direz[caricatore1]=true; 
                            hitt1d=true;
                            knockbackt1=rinculo1;
                        }
                        else
                        {
                            hitt1s=true;
                            knockbackt1=rinculo1;
                        }
                     }           
                }  
            }
            if( e.getKeyChar()=='o' && supercolpo1>=1000)
            {
                supercolpo1=0; abilita1=true;
            }
      
            //secondo giocatore
            if(!stun2)
            {
                if( e.getKeyChar()=='w' && doppiosalto2<2){alto2=true;doppiosalto2++;a2=14;}
                if( e.getKeyChar()=='a' ){sinistra2=true;direzione2=0;}
                if(e.getKeyChar()=='s' ){basso2=true;}
                if( e.getKeyChar()=='d' ){destra2=true;direzione2=1;}
                if( e.getKeyChar()=='g')
                {
                    sparo2=true;
                    if(caricatore2<(munizioni2-1) && ready2 && !ricarica2)
                    {
                        ready2=!ready2;
                        caricatore2++;
                        if(rpg2)
                        {
                            tunf.play();              
                        }
                        else
                        {
                            piu.play();
                        }
                        xsparo2[caricatore2]=x2;
                        ysparo2[caricatore2]=y2+47;
                        if(shotgun2)
                        {
                            shotgunx2[caricatore2]=x2;
                        }
                        if(direzione2==0)
                        {
                            direz2[caricatore2]=true;
                            hitt2d=true;
                            knockbackt2=rinculo2;
                        }
                        else
                        {
                            hitt2s=true;
                            knockbackt2=rinculo2;
                        }
                    }           
                }  
            }
            if( e.getKeyChar()=='f' && supercolpo2>=1000)
            {
                supercolpo2=0; abilita2=true;
            }
        }
        
        
        this.repaint();
    }
    
    // azione da svolgere ogni volta che il timer scatta, cioè ad ogni singolo fotogramma
    public void actionPerformed(ActionEvent e) 
    {
        if(scelta1 && scelta2){scelta=false;}
        //gioco
        if(!menu && !scelta && !impostazioni)
        {
            //movimento primo giocatore
            if( sinistra && !hit1s && !hit1d){x=x-mov1;}
            if(destra && !hit1s && !hit1d){x=x+mov1;}
            if(basso) {y=y+1;}
            if(fermo){}else{y=y+3;}
            if(alto && a<15){y=y-a;a--;}    
            if(a<0){alto=false;a=14;}
            
            
            //movimento secondo giocatore
            if(sinistra2  && !hit2s && !hit2d){x2=x2-mov2;}
            if(destra2 && !hit2s && !hit2d){x2=x2+mov2;}
            if(basso2) {y2=y2+1;}
            if(fermo2){}else{y2=y2+3;}
            if(alto2 && a2<15){y2=y2-a2;a2--;}    
            if(a2<0){alto2=false;a2=14;}
            
            
            
            if(caduto1){respawn1++;}
            if(respawn1>50 && !morto1)
            {
                caduto1=false; respawn1=0; x=larghezza/2; y=0;caccapupu1=0;hitparade2=0;mov1=2;maledizione1=0;galletto2=false;hitparade1=85;
            }
            
            
            if(caduto2){respawn2++;}
            if(respawn2>50 && !morto2)
            {
                caduto2=false; respawn2=0; x2=larghezza/2; y2=0;caccapupu2=0;hitparade1=0;mov2=2;maledizione2=0;galletto1=false;hitparade2=85;
            }
            
            if(morto1){vittoria2=true;}
            if(morto2){vittoria1=true;}
            if(morto1 || morto2)
            {
                
                
                morto2=false;
                morto1=false;
                
                vita1=5;
                vita2=5;
                
                x=larghezza/2-50;
                y=0;
                x2=larghezza/2+50;
                y2=0;
                
                sinistra=false;
                sinistra2=false;
                destra=false;
                destra2=false;
                caduto1=false;
                caduto2=false;
                
                arma1=0;
                arma2=0;
                
                supercolpo1=0;
                supercolpo2=0;
                
                scelta1=false;
                scelta2=false;
                
                mov1=2;
                mov2=2;
                
                maledizione1=0;
                maledizione2=0;
            }
            
            //velocita di sparo
            
            if(!ready1)
            {
                w1++;
                if(w1>reload1){w1=0;ready1=true;}
            }
            
            if(!ready2)
            {
                w2++;
                if(w2>reload2){w2=0;ready2=true;}
            }
            
            
            
            //knockback 1 giocatore
            
            if(r1s>(knockback1/4)){r1s=0;hit1s=false;}
            if(hit1s)
            {
                r1s++;
                x=x-10;    
            }
            
            if(r1d>(knockback1/4)){r1d=0;hit1d=false;}
            if(hit1d)
            {
                r1d++;         
                x=x+10;    
            }
            
            if(t1s>(knockbackt1/4)){t1s=0;hitt1s=false;}
            if(hitt1s)
            {
                t1s++;
                x=x-10;    
            }
            
            if(t1d>(knockbackt1/4)){t1d=0;hitt1d=false;}
            if(hitt1d)
            {
                t1d++;         
                x=x+10;    
            }
            
            //galieo che va giu
            if(gallettino1>21){gallettino1=0;galletto1=false;}
            if(galletto1)
            {
                gallettino1++;
                y2=y2+8;
            }
            
            //knockback 2 giocatore
            
            if(r2s>(knockback2/4)){r2s=0;hit2s=false;}
            if(hit2s)
            {
                r2s++;
                x2=x2-10;   
            }
            
            if(r2d>(knockback2/4)){r2d=0;hit2d=false;}
            if(hit2d)
            {
                r2d++;
                x2=x2+10;    
            }
            if(t2s>(knockbackt2/4)){t2s=0;hitt2s=false;}
            if(hitt2s)
            {
                t2s++;
                x2=x2-10;   
            }
            
            if(t2d>(knockbackt2/4)){t2d=0;hitt2d=false;}
            if(hitt2d)
            {
                t2d++;
                x2=x2+10;    
            }
            
            // galileo che va giu2
            if(gallettino2>21){gallettino2=0;galletto2=false;}
            if(galletto2)
            {
                gallettino2++;
                y=y+8;
            }
            
            //supercolpo speciale 
            
            if (supercolpo1<=999){supercolpo1++;}
            if (supercolpo2<=999){supercolpo2++;}
            
            //abilita dante 1 giocatore
            
            if(hitparade1>=84){hitvirgilio2=false;hitparade1=0;}
            if(hitvirgilio2 && hitparade1<85)
            {
                x2=x2+dx;
                y2=y2+dy;
                hitparade1++;
            }
            
            if(Math.abs(xvirgilio-x2)<10 && Math.abs(yvirgilio-y2)<10 && abilita1)
            {
                abilita1=false;
                hitvirgilio2=true;
            }
            
            //abilita varie
            
            if(abilita1)
            {  
                if(dante1)
                { 
                    virgiliox=x2-xvirgilio; virgilioy=y2-yvirgilio;
                    modulo=(float)Math.sqrt(virgiliox*virgiliox+virgilioy*virgilioy);
                    dx=Math.round(ki*virgiliox/modulo); dy=Math.round(ki*virgilioy/modulo);
                    xvirgilio=xvirgilio+dx;
                    yvirgilio=yvirgilio+dy;
                }
                if(william1)
                {
                    hit1d=false;
                    hit1s=false;
                    hitparade2=84;
                    caccapupu1++;
                    if(caccapupu1==1314)
                    {
                        abilita1=false;
                        caccapupu1=0;
                        supercolpo1=0;
                    }
                }
                if(mose1)
                {
                    stun2=true;
                    caccapupu1++;
                    if(caccapupu1==101)
                    {
                        caccapupu1=0;
                        abilita1=false;
                        stun2=false;
                    }
                }
                if(buonconte1)
                {                
                    y=600;
                    abilita1=false;
                    maledizione2++;
                }
                if(cesare1)
                {   
                    mov2=1;
                    abilita1=false;
                }
                if(galileo1)
                {
                    gallo1=gallo1+2;
                    if(Math.abs(gallo1-y2)<10)
                    {
                        galletto1=true;
                        abilita1=false;
                        gallo1=0;
                    }
                }
            }
            else
            {
                xvirgilio=x;
                yvirgilio=y;
            }
            
            //abilita dante 2 giocatore
            
            if(hitparade2>=84){hitvirgilio1=false;hitparade2=0;}
            if(hitvirgilio1 && hitparade2<85)
            {
                x=x+dx2;
                y=y+dy2;
                hitparade2++;
            }
            
            if(Math.abs(x2virgilio-x)<10 && Math.abs(y2virgilio-y)<10 && abilita2)
            {
                abilita2=false;
                hitvirgilio1=true;
            }
            
            //abilita varie
            
            if(abilita2)
            {  
                if(dante2)
                { 
                    virgiliox2=x-x2virgilio; virgilioy2=y-y2virgilio;
                    modulo2=(float)Math.sqrt(virgiliox2*virgiliox2+virgilioy2*virgilioy2);
                    dx2=Math.round(ki2*virgiliox2/modulo2); dy2=Math.round(ki2*virgilioy2/modulo2);
                    x2virgilio=x2virgilio+dx2;
                    y2virgilio=y2virgilio+dy2;
                }
                if(william2)
                {
                    hit2d=false;
                    hit2s=false;
                    hitparade1=84;
                    caccapupu2++;
                    if(caccapupu2==1314)
                    {
                        abilita2=false;
                        caccapupu2=0;
                        supercolpo2=0;
                    }
                }
                if(mose2)
                {
                    stun1=true;
                    caccapupu2++;
                    if(caccapupu2==101)
                    {
                        caccapupu2=0;
                        abilita2=false;
                        stun1=false;
                    }
                }
                if(buonconte2)
                {
                    y2=600;
                    abilita2=false;
                    maledizione1++;
                }
                 if(cesare2)
                {   
                    mov1=1;
                    abilita2=false;
                }
                if(galileo2)
                {
                    gallo2=gallo2+2;
                    if(Math.abs(gallo2-y)<10)
                    {
                        galletto2=true;
                        abilita2=false;
                        gallo2=0;
                    }
                }
            }
            else
            {
                x2virgilio=x2;
                y2virgilio=y2;
            }
            
            
            
            
            //armi
            
            switch (arma1)
            {
                case 0: munizioni1=21;
                
                        pistola1=true;
                        shotgun1=false;
                        assault1=false;
                        sniper1=false;
                        rpg1=false;
                        
                        
                        reload1=15;
                        rinculo1=4;
                        
                        break;
                        
                case 1: munizioni1=11;
                
                        shotgun1=true;
                        pistola1=false;  
                        assault1=false;
                        sniper1=false;
                        rpg1=false;
                        
                        
                        reload1=35;
                        rinculo1=7;
                        
                        break;
                        
                case 2: munizioni1=31;
                
                        assault1=true;
                        shotgun1=false;
                        pistola1=false;  
                        sniper1=false;
                        rpg1=false;
                       
                        
                        reload1=10;
                        rinculo1=5;
                        
                        break;
                        
                case 3: munizioni1=6;
                
                        sniper1=true;
                        shotgun1=false;
                        pistola1=false;  
                        assault1=false;
                        rpg1=false;
                        
                        
                        reload1=50;
                        rinculo1=19;
                        
                        break;
                        
               
                        
                case 4: munizioni1=2;
                
                        rpg1=true;
                        shotgun1=false;
                        pistola1=false;  
                        assault1=false;
                        sniper1=false;
                        
                        
                        rinculo1=60;
                        
                        break;
            }
            
            switch (arma2)
            {
                case 0: munizioni2=21;
                
                        pistola2=true;
                        shotgun2=false;
                        assault2=false;
                        sniper2=false;
                        rpg2=false;
                       
                        
                        reload2=15;
                        rinculo2=4;
                        
                        break;
                        
                case 1: munizioni2=11;
                
                        shotgun2=true;
                        pistola2=false;  
                        assault2=false;
                        sniper2=false;
                        rpg2=false;
                        
                        
                        reload2=35;
                        rinculo2=8;
                        
                        break;
                        
                case 2: munizioni2=31;
                
                        assault2=true;
                        shotgun2=false;
                        pistola2=false;  
                        sniper2=false;
                        rpg2=false;
                       
                        reload2=10;
                        rinculo2=7;
                        
                        break;
                        
                case 3: munizioni2=6;
                
                        sniper2=true;
                        shotgun2=false;
                        pistola2=false;  
                        assault2=false;
                        rpg2=false;
                     
                        reload2=50;
                        rinculo2=19;
                        
                        break;
                        
               
                case 4: munizioni2=2;
                
                        rpg2=true;                        
                        shotgun2=false;
                        pistola2=false;  
                        assault2=false;
                        sniper2=false;
                        
                        rinculo2=60;
                        
                        break;
            }   
            
            //sparo giocatore 1
            if(sparo1)
            {
                for(int i=0;i<201;i++)
                {
                    if(xsparo1[i]>1030 || xsparo1[i]<-10){}else
                    {
                        if(direz[i])
                        {
                            xsparo1[i]=xsparo1[i]-6;
                            if(Math.abs((x2+5)-xsparo1[i])<6 && Math.abs((y2+40)-(ysparo1[i]))<40) 
                            {
                                xsparo1[i]=1035;
                                hit2s=true;
                                if(pistola1){knockback2=50;}
                                if(shotgun1){knockback2=150;}
                                if(assault1){knockback2=65;}
                                if(sniper1){knockback2=180;}                                
                                if(rpg1){knockback2=400;}
                            }
                        }
                        else
                        {
                            xsparo1[i]=xsparo1[i]+6;
                            if(Math.abs((x2+5)-xsparo1[i])<6 && Math.abs((y2+40)-(ysparo1[i]))<80)
                            {
                                xsparo1[i]=1035;
                                hit2d=true;
                                if(pistola1){knockback2=50;}
                                if(shotgun1){knockback2=150;}
                                if(assault1){knockback2=65;}
                                if(sniper1){knockback2=180;}
                                if(rpg1){knockback2=400;}             
                            }
                        }
                        if(Math.abs(shotgunx1[i]-xsparo1[i])>100 && shotgun1)
                        {
                            xsparo1[i]=1031;
                        }
                    }
                }
            }
            
            //sparo giocatore 2
            if(sparo2)
            {
                for(int i=0;i<201;i++)
                {
                    if(xsparo2[i]>1030 || xsparo2[i]<-10){}else
                    {
                        if(direz2[i])
                        {
                            xsparo2[i]=xsparo2[i]-6;
                            if(Math.abs((x+5)-xsparo2[i])<6 && Math.abs((y+40)-(ysparo2[i]))<40) 
                            {
                                xsparo2[i]=1031;
                                hit1s=true;
                                if(pistola2){knockback1=50;}
                                if(shotgun2){knockback1=150;}
                                if(assault2){knockback1=65;}
                                if(sniper2){knockback1=180;}
                                if(rpg2){knockback1=400;}
                            }
                        }
                        else
                        {
                            xsparo2[i]=xsparo2[i]+6;
                            if(Math.abs((x+5)-xsparo2[i])<6 && Math.abs((y+40)-(ysparo2[i]))<40) 
                            {
                                xsparo2[i]=1031;
                                hit1d=true;
                                if(pistola2){knockback1=50;}
                                if(shotgun2){knockback1=150;}
                                if(assault2){knockback1=65;}
                                if(sniper2){knockback1=180;}
                                if(rpg2){knockback1=400;}
                            }
                        }
                        if(Math.abs(shotgunx2[i]-xsparo2[i])>100 && shotgun2)
                        {
                            xsparo2[i]=1031;
                        }
                    }
                }
            }
            
            
            
         
            
            //ricarica giocatore 1
            if(caricatore1>=(munizioni1-1)){ricarica=true;}
            if(ricarica){b++;}
            if(b>300)
            {
                b=0;
                ricarica=false;
                if(scatola1)
                {
                }
                else
                {
                    arma1=0;
                }
                scatola1=false;
                caricatore1=0;
                for(int q=0;q<50;q++){direz[q]=false;}
            }
            
            //ricarica giocatore 2
            
            if(caricatore2>=(munizioni2-1)){ricarica2=true;}
            if(ricarica2){d++;}
            if(d>300)
            {
                d=0;
                ricarica2=false;
                if(scatola2)
                {
                }
                else
                {
                    arma2=0;
                }
                scatola2=false;
                caricatore2=0;
                for(int q=0;q<50;q++){direz2[q]=false;}
            }
            
            
            //collisioni
            //piattaforma alta centrale
            if(Math.abs(y-20)<4 && x>281 && x<491) {fermo=true;doppiosalto=0;y=20;}else{fermo=false;}
            if(Math.abs(y2-20)<4 && x2>281 && x2<491){fermo2=true;doppiosalto2=0;y2=20;}else{fermo2=false;}
            
            //piattaforme centrali centrali
            if(Math.abs(y-120)<4 && x>522 && x<682) {fermo=true;doppiosalto=0;y=120;}else{fermo=false;}
            if(Math.abs(y2-120)<4 && x2>522 && x2<682){fermo2=true;doppiosalto2=0;y2=120;}else{fermo2=false;}

            if(Math.abs(y-120)<4 && x>90 && x<250) {fermo=true;doppiosalto=0;y=120;}else{fermo=false;}
            if(Math.abs(y2-120)<4 && x2>90 && x2<250){fermo2=true;doppiosalto2=0;y2=120;}else{fermo2=false;}
            
            if(Math.abs(y-217)<10 && Math.abs(x-303)<10 && spawnarma)
            {
                arma1=arma;
                spawnarma=false;
                ricarica=true;
                scatola1=true;
            }
            
            //piattaforma bassa centrale
            if(Math.abs(y-220)<4 && x>190 && x<582){fermo=true;doppiosalto=0;y=220;}else{fermo=false;}
            if(Math.abs(y2-220)<4 && x2>190 && x2<582){fermo2=true;doppiosalto2=0;y2=220;}else{fermo2=false;}
            if(Math.abs(y2-217)<10 && Math.abs(x2-303)<10 && spawnarma)
            {
                arma2=arma;
                spawnarma=false;
                ricarica2=true;
                scatola2=true;
            }
            
            
            if(y>600 && !caduto1)
            {
                vita1=vita1-maledizione1-1;
                caduto1=true;
                arma1=0;
                if (vita1==0)
                {
                    morto1=true;
                }
            }   
            
            if(y2>600 && !caduto2)
            {
                vita2=vita2-maledizione2-1;
                caduto2=true;
                arma2=0;
                if (vita2==0)
                {
                    morto2=true;
                }
            }   
            
            //variabili supercolpo per l'area grafica
            gsupercolpo1=(int) supercolpo1/20;
            gsupercolpo2=(int) supercolpo2/20;
            
            //spawn armi
            h++;
            if(h>200){h=0;arma=k.nextInt(4)+1;spawnarma=true;}
            
            for(int i=0;i<201;i++)
                {
                    if(ysparo2[i]<10)
                    {
                        xsparo2[i]=1030;       
                    }
                    
                    if(ysparo1[i]<10)
                    {
                        xsparo1[i]=1030;
                    }
                }
            
            
            
            
        }
        this.repaint();
    }
    
    public void mouseClicked(MouseEvent e) 
    {
        int x= e.getX();  int y= e.getY();            
        
        if(menu && !impostazioni)
        {
            scelta=false;
            scelta2=false;
            if(Math.abs(x-(larghezza/2))<159 && Math.abs(y-(altezza/2))<210)
            {
                menu=false;
                scelta=true;
                scelta2=false;
            }
        
            
        }
        if(impostazioni){impostazioni=false;}
        if(Math.abs(x-15)<15 && Math.abs(y-15)<15)
            {
              impostazioni=true;            
            }
        
        if(vittoria1){menu=true; vittoria1=false;}
        if(vittoria2){menu=true; vittoria2=false;}
        
        this.repaint();
     }
     public void mousePressed(MouseEvent e) 
     {
        falsone.play();
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) 
    {
      int x= e.getX();  int y= e.getY();     
      if(Math.abs(x-(larghezza/2))<159 && Math.abs(y-(altezza/2))<210)
            {
                on=true;
            }
            else
            {
                on=false;
            }
            
    
    }
    public void mouseDragged(MouseEvent e) {}     
  
    public void keyReleased( KeyEvent e ) 
    {
        if(!menu && !scelta && !impostazioni)
        {
            //primo giocatore
            if( e.getKeyCode()==KeyEvent.VK_LEFT){sinistra=false;}
            if( e.getKeyCode()==KeyEvent.VK_RIGHT){destra=false;}
            if( e.getKeyCode()==KeyEvent.VK_DOWN){basso=false;}
      
            //secondo fucking giocatore
            if( e.getKeyChar()=='a'){sinistra2=false;}
            if( e.getKeyChar()=='d'){destra2=false;}
            if( e.getKeyChar()=='s'){basso2=false;}

            this.repaint();  
        }
    }
    public void keyTyped( KeyEvent e ) {}
    // quando l'applet si avvia, si crea il timer e comincia ad andare
    
    public void start() 
    {
        t = new Timer(12,this);
        t.start();
    }
    
    // quando l'applet termina, si si ferma il timer e si distrugge
    public void stop() 
    {
        t.stop();
        t=null;          
    }
 
    class AreaGrafica extends JPanel
    {
        // singolo fotogramma
            public void paint(Graphics g) {
            //super.paintComponent(g);
            g.drawImage(sfondo,0,0,this);
            larghezza = getSize().width;
            altezza = getSize().height;
            
            g.drawImage(rotella,0,0,this);
              
            if(menu && !impostazioni)
            {
                if(on){g.drawImage(bcpp,larghezza/2-159,altezza/2-210,this);}else{g.drawImage(bcp,larghezza/2-159,altezza/2-210,this);}
            }
            if(impostazioni)
            {
                g.drawImage(comandi,0,0,this);
            }
            if(scelta && !impostazioni)
            {
              g.drawImage(selezione,0,0,this);
                 switch (personaggio1)
              {
                case 0: g.drawImage(dantemenu,50,150,300,178,this);
                        
                        break;
                        
                case 1: g.drawImage(williammenu,50,150,300,178,this);
                        
                        break;
                        
                case 2: g.drawImage(cesaremenu,50,150,300,178,this);
                        
                        break;
                        
                case 3: g.drawImage(mosemenu,50,150,300,178,this);
                        
                        break;
                        
                case 4: g.drawImage(buoncontemenu,50,150,300,178,this);
                        
                        break;
                        
                case 5: g.drawImage(galileomenu,50,150,300,178,this);
                        
                        break;
              }   
                 switch (personaggio2)
              {
                case 0: g.drawImage(dantemenu,450,150,300,178,this);
                        
                        break;
                        
                case 1: g.drawImage(williammenu,450,150,300,178,this);
                        
                        break;
                        
                case 2: g.drawImage(cesaremenu,450,150,300,178,this);
                        
                        break;
                        
                case 3: g.drawImage(mosemenu,450,150,300,178,this);
                        
                        break;
                        
                case 4: g.drawImage(buoncontemenu,450,150,300,178,this);
                        
                        break;
                        
                case 5: g.drawImage(galileomenu,450,150,300,178,this);
                        
                        break;
              }  
            }
              
              if(!menu && !scelta && !impostazioni)
            {
                
                if(vittoria1 || vittoria2){
                if(vittoria1)
                {
                   
                    g.drawString("IL GIOCATORE 1 HA VINTO!!!",larghezza/2-10,altezza/2);
                }
                if(vittoria2)
                {
                    menu=false;
                    scelta=false;
                    g.drawString("IL GIOCATORE 2 HA VINTO!!!",larghezza/2-10,altezza/2);
                }
                 }
                 else
                {
                    
                    //dante
                    if(dante2)
                    {
                        if(direzione2==1){g.drawImage(dante,x2,y2,this);}else{g.drawImage(dantes,x2,y2,this);}
                    }
                    if(dante1)
                    {
                        if(direzione==1){g.drawImage(dante,x,y,this);}else{g.drawImage(dantes,x,y,this);}
                    }
                    //cesare
                    if(cesare2)
                    {
                        if(direzione2==1){g.drawImage(cesare,x2,y2,this);}else{g.drawImage(cesares,x2,y2,this);}
                    }                
                    if(cesare1)
                    {
                        if(direzione==1){g.drawImage(cesare,x,y,this);}else{g.drawImage(cesares,x,y,this);}
                    }
                    //william
                    if(william2)
                    {
                        if(direzione2==1){g.drawImage(william,x2,y2,this);}else{g.drawImage(williams,x2,y2,this);}
                    }                
                    if(william1)
                    {
                        if(direzione==1){g.drawImage(william,x,y,this);}else{g.drawImage(williams,x,y,this);}
                    }
                    //mose
                    if(mose2)
                    {
                        if(direzione2==1){g.drawImage(mose,x2,y2,this);}else{g.drawImage(moses,x2,y2,this);}
                    }
                    if(mose1)
                    {  
                        if(direzione==1){g.drawImage(mose,x,y,this);}else{g.drawImage(moses,x,y,this);}
                    }
                    //buonconte
                     if(buonconte2)
                    {
                        if(direzione2==1){g.drawImage(buonconte,x2,y2,this);}else{g.drawImage(buoncontes,x2,y2,this);}
                    }
                    if(buonconte1)
                    {
                        if(direzione==1){g.drawImage(buonconte,x,y,this);}else{g.drawImage(buoncontes,x,y,this);}
                    }
                    
                    //galileo
                    if(galileo2)
                    {
                        if(direzione2==1){g.drawImage(galileo,x2,y2,this);}else{g.drawImage(galileos,x2,y2,this);}
                    }
                    if(galileo1)
                    {
                        if(direzione==1){g.drawImage(galileo,x,y,this);}else{g.drawImage(galileos,x,y,this);}
                    }
                    
                     //arma
                    if(!ricarica)
                    {
                      if(direzione==1)
                      {
                        if(pistola1){g.drawImage(pistola,x+20,y+45,this);}
                        if(shotgun1){g.drawImage(shotgun,x+20,y+45,this);}
                        if(assault1){g.drawImage(assalto,x,y+47,this);}
                        if(sniper1){g.drawImage(sniper,x,y+47,this);}
                        if(rpg1){g.drawImage(rpg,x-30,y+47,this);}
                      }
                      if(direzione==0)
                      {
                        if(pistola1){g.drawImage(pistolas,x-25,y+45,this);}
                        if(shotgun1){g.drawImage(shotguns,x-25,y+45,this);}
                        if(assault1){g.drawImage(assaltos,x-25,y+47,this);}
                        if(sniper1){g.drawImage(snipers,x-25,y+47,this);}
                        if(rpg1){g.drawImage(rpgs,x-25,y+47,this);}
                      }
                    }
                    
                     if(!ricarica2)
                    {
                      if(direzione2==1)
                      {
                        if(pistola2){g.drawImage(pistola,x2+20,y2+45,this);}
                        if(shotgun2){g.drawImage(shotgun,x2+20,y2+45,this);}
                        if(assault2){g.drawImage(assalto,x2,y2+47,this);}
                        if(sniper2){g.drawImage(sniper,x2,y2+47,this);}
                        if(rpg2){g.drawImage(rpg,x2,y2+47,this);}
                      }
                      if(direzione2==0)
                      {
                        if(pistola2){g.drawImage(pistolas,x2-25,y2+45,this);}
                        if(shotgun2){g.drawImage(shotguns,x2-25,y2+45,this);}
                        if(assault2){g.drawImage(assaltos,x2-25,y2+47,this);}
                        if(sniper2){g.drawImage(snipers,x2-25,y2+47,this);}
                        if(rpg2){g.drawImage(rpgs,x2,y2+47,this);}
                      }
                    }
                    
                    g.drawImage(boh,20,320,this);
                    g.drawImage(bohs,larghezza-200,320,this);
                    //Piattaforma alta centrale
                    g.drawRect(291,100,200,10);
                    
                    g.drawRect(100,200,150,10);
                    g.drawRect(532,200,150,10);
                    
                    //Piattaforma bassa centrale
                    g.drawRect(200,300,382,10);  
                    
                    //fa vedere quando hai la supermossa 
                    g.drawRect(60,397,gsupercolpo1,10);
                    g.drawRect(larghezza-110,397,gsupercolpo2,10);
                    g.drawLine(110,395,110,409);
                    g.drawLine(larghezza-60,395,larghezza-60,409);
                    
                    
                    
                    if(spawnarma)
                    {
                        g.drawRect(300,294,6,6);
                    }
                  
                    //abilita1
                    if(abilita1)
                    {
                        if(dante1)
                        {
                            if(dx>0)
                            {
                                g.drawImage(virgilio,xvirgilio,yvirgilio,this);
                            }
                            else
                            {
                                g.drawImage(virgilios,xvirgilio,yvirgilio,this);
                            }
                        }
                        if(william1)
                        {
                            g.drawRect(100,397,10,10);
                        }
                        if(mose1)
                        {
                            g.drawRect(100,397,10,10);
                        }
                        if(galileo1)
                        {                         
                           g.drawImage(roccia,x2,gallo1,this);
                        }
                    }
                  
                    //abilita2
                    if(abilita2)
                    {
                        if (dante2)
                        {
                           if(dx2>0)
                            {
                                g.drawImage(virgilio,x2virgilio,y2virgilio,this);
                            }
                            else
                            {
                                g.drawImage(virgilios,x2virgilio,y2virgilio,this);
                            }
                        }
                        if(william2)
                        {
                            g.drawRect(larghezza-30,397,10,10);
                        }
                        if(mose2)
                        {
                            g.drawRect(larghezza-30,397,10,10);
                        }
                        if(galileo2)
                        {
                           g.drawImage(roccia,x,gallo2,this);
                        }
                    }
                    
                    //proiettili primo giocatore
                    if(sparo1)
                    {    
                        for(int z=0;z<=caricatore1;z++)
                        {
                            if(xsparo1[z]>1030 || xsparo1[z]<-10){}else
                            {
                                g.drawRect(xsparo1[z],ysparo1[z],2,2);
                            }
                        }
                    }
                    
                    //proiettili secondo fucking giocatore
                    if(sparo2)
                    {
                        for(int z=0;z<=caricatore2;z++)
                        {
                            if(xsparo2[z]>1024 || xsparo2[z]<0){}else
                            {
                                g.drawRect(xsparo2[z],ysparo2[z],2,2);
                            }
                        }
                    }
                  
                  
                    if(ricarica)
                    {
                        g.drawString("reloading",60,altezza-70);
                    }
                    else
                    {
                        g.drawString("munizioni 1: "+(munizioni1-1-caricatore1),60,altezza-70);
                    }
                  
                    
                    if(ricarica2)
                    {
                        g.drawString("reloading",larghezza-140,altezza-70);
                    }
                    else
                    {
                        g.drawString("munizioni 2: "+(munizioni2-1-caricatore2),larghezza-140,altezza-70);
                    }
                    //hud1
                    g.drawString("vita 1: "+vita1,60,altezza-55);
                    g.drawString("vita 2: "+vita2,larghezza-140,altezza-55);
                    
                      switch (maledizione1)
                    {
                        case 0:
                        
                                break;
                         
                        case 1: g.drawImage(maledizione,60,altezza-25,this);
                        
                                break;
                        
                        case 2: g.drawImage(maledizione,60,altezza-25,this);
                                g.drawImage(maledizione,80,altezza-25,this);
                        
                                break;
                        
                        case 3: g.drawImage(maledizione,60,altezza-25,this);
                                g.drawImage(maledizione,80,altezza-25,this);
                                g.drawImage(maledizione,100,altezza-25,this);
                        
                                break;
                        
                        case 4: g.drawImage(maledizione,60,altezza-25,this);
                                g.drawImage(maledizione,80,altezza-25,this);
                                g.drawImage(maledizione,100,altezza-25,this);
                                g.drawImage(maledizione,120,altezza-25,this);
              
                                break;
                     
                    }  
                    
                     
                      switch (maledizione2)
                    {
                        case 0:
                        
                                break;
                         
                        case 1: g.drawImage(maledizione,larghezza-140,altezza-25,this);
                        
                                break;
                        
                        case 2: g.drawImage(maledizione,larghezza-140,altezza-25,this);
                                g.drawImage(maledizione,larghezza-120,altezza-25,this);
                        
                                break;
                        
                        case 3: g.drawImage(maledizione,larghezza-140,altezza-25,this);
                                g.drawImage(maledizione,larghezza-120,altezza-25,this);
                                g.drawImage(maledizione,larghezza-100,altezza-25,this);
                        
                                break;
                        
                        case 4: g.drawImage(maledizione,larghezza-140,altezza-25,this);
                                g.drawImage(maledizione,larghezza-120,altezza-25,this);
                                g.drawImage(maledizione,larghezza-100,altezza-25,this);
                                g.drawImage(maledizione,larghezza-80,altezza-25,this);
              
                                break;
                     
                    }  
                    
                    
                    
                    g.drawString("v 0.8.2",larghezza-50,10);
                }
            }
        }
    }
}


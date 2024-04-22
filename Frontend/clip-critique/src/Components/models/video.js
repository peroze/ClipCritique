export class Video {
    

    constructor(id,imageurl,url,uploader,videoname,rating,date,count,percentage) { 
        this.id=id;
        this.imageurl=imageurl;
        this.uploader=uploader;
        this.rating=rating;
        this.videoname=videoname;
        this.count=count;
        this.percentage =percentage;
        this.date=date;
        this.url=url;
     }    
    
    }

    export class videomin{

        constructor(id, imageurl, url, uploader, videoname, date)  {

            this.id=id;
            this.imageurl=imageurl;
            this.uploader=uploader;
            this.videoname=videoname;
            this.date=date;
            this.url=url;
         } 
         
    }
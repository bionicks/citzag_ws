package com.citzag.builder;

import java.math.BigDecimal;

import com.citzag.daos.CzZag;
import com.citzag.model.instagram.Zag;
import com.citzag.utils.JSONizer;

public class ZagBuilder {

	/*
	 * {
      "attribution": null,
      "tags": [
        "citzag",
        "tag"
      ],
      "type": "image",
      "location": {
        "latitude": 39.570577493,
        "name": "Plaza Den Coll",
        "longitude": 2.651962955,
        "id": 260818148
      },
      "comments": {
        "count": 0,
        "data": []
      },
      "filter": "Inkwell",
      "created_time": "1425828011",
      "link": "https://instagram.com/p/z-LWMMKr36/",
      "likes": {
        "count": 1,
        "data": [
          {
            "username": "jonascanyellas",
            "profile_picture": "https://instagramimages-a.akamaihd.net/profiles/anonymousUser.jpg",
            "id": "177382734",
            "full_name": ""
          }
        ]
      },
      "images": {
        "low_resolution": {
          "url": "http://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/11055967_924947070869987_1263972952_n.jpg",
          "width": 306,
          "height": 306
        },
        "thumbnail": {
          "url": "http://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/s150x150/e15/11055967_924947070869987_1263972952_n.jpg",
          "width": 150,
          "height": 150
        },
        "standard_resolution": {
          "url": "http://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/e15/11055967_924947070869987_1263972952_n.jpg",
          "width": 640,
          "height": 640
        }
      },
      "users_in_photo": [],
      "caption": {
        "created_time": "1425828011",
        "text": "#citzag #tag comentarios instagram ejemplos",
        "from": {
          "username": "jonascanyellas",
          "profile_picture": "https://instagramimages-a.akamaihd.net/profiles/anonymousUser.jpg",
          "id": "177382734",
          "full_name": ""
        },
        "id": "943316779011850123"
      },
      "user_has_liked": true,
      "id": "936235675968781818_177382734",
      "user": {
        "username": "jonascanyellas",
        "profile_picture": "https://instagramimages-a.akamaihd.net/profiles/anonymousUser.jpg",
        "id": "177382734",
        "full_name": ""
      }
    },
    {
	 */
	
	public static CzZag buildDao( Zag zag ){
		if ( zag == null ) return null;
		CzZag o = new CzZag();
		if ( zag.getCaption() != null ){
			o.setCreated( Long.parseLong( zag.getCaption().getCreated_time() ));
		}else return null;
		o.setIdInstagram( new BigDecimal( zag.getId().split("_")[0] ));
		o.setIdInstagramUser( Integer.parseInt( zag.getUser().getId() ) );
		if ( zag.getLocation() != null ){
			o.setLatitude(  zag.getLocation().getLatitude().doubleValue() );
			o.setLongitude( zag.getLocation().getLongitude().doubleValue() );
		}
		o.setTags(new String());
		for ( String tag : zag.getTags() ) o.setTags( o.getTags().concat( "#" + tag ));
		o.setContent( JSONizer.toJson(zag));		
		return o;
	}
	
}

/**
 * Created by Administrator on 2017/3/5 0005.
 */
import React from "react";
import Chip from 'material-ui/Chip';

function handleTouchTap(){

}
const CategoryItem = () => (
  <div style={{
    display:'flex',
    justifyContent:'space-between',
    paddingLeft:20,
    paddingRight:20,
alignItems:'center'
  }}>
    <a href="#">title</a>
    <Chip onTouchTap={handleTouchTap}
          style={{  display: 'flex',
            alignItems: 'center',
            marginRight: 10,
            height: 15,marginTop:5,marginBottom:5,fontSize:5}}
    ><p style={{fontSize:10,fontcolor:'#00ff00'}}>1</p></Chip>
  </div>
);
export default CategoryItem;

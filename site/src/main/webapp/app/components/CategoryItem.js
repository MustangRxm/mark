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
          style={{marginTop:5,marginBottom:5,fontSize:5}}
    >1</Chip>
  </div>
);
export default CategoryItem;

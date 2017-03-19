/**
 * Created by Administrator on 2017/3/9 0009.
 */
import React from "react";
import Paper from "material-ui/Paper";
import Divider from "material-ui/Divider";
import CategoryItem from "./CategoryItem";
import FontIcon from "material-ui/FontIcon";
const iconStyles = {
  // marginRight: 24,

  fontSize:'18px'
};
const Categories = () => (
<Paper zDepth={2} >
  <div style={{
    padding:5,
    marginLeft:5,
    display:'flex',
    alignItems:'center',
  }}> <FontIcon className="material-icons md-light  md-48" Style={iconStyles}>view_list</FontIcon>

    <p><b>Categories</b></p></div>
  <Divider/>
  <CategoryItem/>
  <Divider/>
  <CategoryItem/>
  <Divider/>
  <CategoryItem/>
</Paper>
);


export default Categories;

/**
 * Created by Administrator on 2017/3/9 0009.
 */
import React from "react";
import Paper from 'material-ui/Paper';
import Divider from 'material-ui/Divider';
import CategoryItem from  './CategoryItem';
import ContentInbox from 'material-ui/svg-icons/content/inbox';

const Categories = () => (
<Paper zDepth={2} >
  <div style={{
    padding:5,
    marginLeft:5,
    display:'flex',
    alignItems:'center',
  }}><ContentInbox /><p>test title</p></div>

  <Divider/>
  <CategoryItem/>
  <Divider/>
  <CategoryItem/>
  <Divider/>
  <CategoryItem/>
</Paper>
);


export default Categories;

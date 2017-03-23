/**
 * Created by Administrator on 2017/3/9 0009.
 */
import React from "react";
import Paper from "material-ui/Paper";
import Divider from "material-ui/Divider";
import TagsItem from "./TagsItem";
import FontIcon from "material-ui/FontIcon";
function handleTouchTap(){

}
const iconStyles = {
  fontSize:'18px'
};


const Tags = () => (
  <Paper zDepth={2} >

    <div style={{
      padding:5,
      marginLeft:5,
      display:'flex',
      alignItems:'center',
    }}><FontIcon className="material-icons md-light  md-48" style={iconStyles} >label</FontIcon><h4>Tags</h4></div>
    <Divider/>
    <div style={{
      display:'flex',
      flexWrap:'wrap'
    }}>

    <TagsItem/>
    <TagsItem/>
    <TagsItem/>
    <TagsItem/>
    <TagsItem/>
    <TagsItem/>
    <TagsItem/>
    <TagsItem/>
      </div>
    {/*<a href="#">title</a>*/}
    {/*<Chip  onTouchTap={handleTouchTap} >1</Chip>*/}
    </Paper>
);
export default Tags;

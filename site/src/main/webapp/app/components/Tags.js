/**
 * Created by Administrator on 2017/3/9 0009.
 */
import React from "react";
import Chip from 'material-ui/Chip';
import Paper from 'material-ui/Paper';
import Divider from 'material-ui/Divider';
import ContentInbox from 'material-ui/svg-icons/content/inbox';
import TagsItem from './TagsItem';
function handleTouchTap(){

}
const Tags = () => (
  <Paper zDepth={2} >

    <div style={{
      padding:5,
      marginLeft:5,
      display:'flex',

      alignItems:'center',
    }}><ContentInbox /><p>test title</p></div>
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

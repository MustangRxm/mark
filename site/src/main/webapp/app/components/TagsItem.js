/**
 * Created by Administrator on 2017/3/10 0010.
 */
import React from "react";
import Chip from 'material-ui/Chip';
import Paper from 'material-ui/Paper';
import Divider from 'material-ui/Divider';
import ContentInbox from 'material-ui/svg-icons/content/inbox';
function handleTouchTap(event){
console.log(event.target.innerHTML);
  console.log(event.target)
}
// const TagsItem = () => (
//
//
// );

export default class TagsItem extends React.Component{
   click(test) {
console.log(test);
  }
  render(){
    return (
      <Chip style={{
        margin:5
      }} onTouchTap={handleTouchTap} onClick={this.click.bind(this,this.props.tagId)}>{this.props.tagName} </Chip>
    )
  }
}

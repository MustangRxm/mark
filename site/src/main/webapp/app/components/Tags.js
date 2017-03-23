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

export default class Tags extends React.Component{
  constructor(props){
    super(props);
    this.setState({
      dataList: []
    });
  }

  componentWillMount(){
    this.setState({
      dataList:[
        {tagName:'tag1',tagId:123},
        {tagName:'tag2',tagId:12123},
      ]
    });
  }
  render (){
    return (
      <Paper zDepth={2} >

        <div style={{
          marginLeft:5,
          display:'flex',
          alignItems:'center',
        }}><FontIcon className="material-icons md-light  md-48" style={iconStyles} >label</FontIcon><h4>Tags</h4></div>
        <Divider/>
        <div style={{
          display:'flex',
          flexWrap:'wrap'
        }}>
          {this.state.dataList.map(function (item,i) {
              return  <TagsItem key={i} tagName={item.tagName} tagId={item.tagId}/>
          })}

        </div>
        {/*<a href="#">title</a>*/}
        {/*<Chip  onTouchTap={handleTouchTap} >1</Chip>*/}
      </Paper>
    )

  }
}

/**
 * Created by m1 on 17-3-2.
 */
import React from "react";
import {List, ListItem} from "material-ui/List";
import RecentPosts from "./RecentPosts";
import Categories from "./Categories";
import Tags from "./Tags";

const styles = {
  chip: {
    margin: 4,
  },
  wrapper: {
    display: 'flex',
    flexWrap: 'wrap',
  },
};

export default class RightBody extends React.Component{
  // componentWillMount(){
  //   this.setState({
  //     dataList:[
  //       {title:'i am title1',url:'www.baidu.com'},
  //       {title:'i am title12',url:'www.baidu2.com'},
  //       {title:'i am title13',url:'www.baidu3.com'},
  //     ]
  //   });
  // }

  render() {
    return (
      <div className="rightBody" style={{
        display:'flex',
        flexDirection:'column',
        marginLeft:20,
        flex:2
      }}>
        <RecentPosts />
        <br/>

        <Categories/>
        <br/>
        <Tags/>
      </div>
    );
  }
}


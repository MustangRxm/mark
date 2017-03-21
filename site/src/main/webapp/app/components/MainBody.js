/**
 * Created by m1 on 17-3-2.
 */
import React from "react";
import Paper from 'material-ui/Paper';
import {List, ListItem} from 'material-ui/List';
import Divider from 'material-ui/Divider';
import CardItem from './CardItem'

// const MainBody = () => (
export default class MainBody extends React.Component {

  render() {
    return (
      <div className="mainBody" style={{
        display: 'flex',
        flexDirection: 'column',
        flex: 4,
        marginLeft: 40

      }}>
        {this.props.data.map(function (item,i) {
              {/*console.log(item);*/}
         return <div   key={i}>
          <CardItem tagList={item.tagList}
                    category={item.category}
                    author={item.author}
                    title={item.title}
                    text={item.text}
                    createDatetime={item.createDatetime}

          /><br/> </div>
        })}
      </div>

    );
  }

// );
}
// export default MainBody;

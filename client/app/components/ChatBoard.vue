<script>
import ChatRoom from './ChatRoom.vue';
import gsap from 'gsap';
import Draggable from 'gsap/Draggable';

export default {
  name: 'ChatBoard',
  data() {
    return {};
  },
  components: {
    ChatRoom,
  },
  mounted() {
    // Adapted from https://codepen.io/GreenSock/pen/zYdzPaj
    gsap.registerPlugin(Draggable);

    let win = document.getElementById('win');
    let boundary = document.getElementById('boundary');

    let zoom = {
      value: 1.0,
      min: .6,
      max: 2,
      step: 1,
      factor: 1.1,
    };

    win.addEventListener('wheel', wheelAction);

    gsap.set(win, { scale: zoom.value, transformOrigin: 'left top'});

    let props = gsap.getProperty(win);

    let draggable = new Draggable(win, {
      cursor: 'inherit',
      minimumMovement: 10,
      allowEventDefault: true,
      overshootTolerance: 0,
      dragClickables: false,
    });

    setBounds();

    function wheelAction(event) {
      event.preventDefault();

      let oldZoom = zoom.value;

      let wheel = event.deltaY / 100;

      if (wheel > 0) {
        zoom.value /= zoom.factor;
      } else {
        zoom.value *= zoom.factor;
      }

      zoom.value = gsap.utils.clamp(zoom.min, zoom.max, zoom.value);

      changeZoom(zoom.value - oldZoom, event);
    }

    function changeZoom(zoomDelta, event) {
      let scale = props('scaleX');
      let x = props('x');
      let y = props('y');

      let rect = boundary.getBoundingClientRect();
      let globalX = event.clientX - rect.left;
      let globalY = event.clientY - rect.top;

      let localX = (globalX - x) / scale;
      let localY = (globalY - y) / scale;

      x += -(localX * zoomDelta);
      y += -(localY * zoomDelta);

      gsap.set(win, {
        scale: zoom.value,
        x: x,
        y: y,
      });

      setBounds();
    }

    function setBounds() {
      let winWidth = win.offsetWidth;
      let winHeight = win.offsetHeight;
      let boundWidth = boundary.offsetWidth;
      let boundHeight = boundary.offsetHeight;
      
      let dx = boundWidth - winWidth * zoom.value;
      let dy = boundHeight - winHeight * zoom.value;

      let width = boundWidth - dx * 2;
      let height = boundHeight - dy * 2;

      draggable.applyBounds({
        left: dx,
        top: dy,
        width: width,
        height: height,
      });
    }

    window.addEventListener('resize', setBounds);
  },
};
</script>

<template>
  <div id="boundary" class="drag-boundary">
    <div id="win" class="chat-board">
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
      <chat-room Topic="General" />
    </div>
  </div>
</template>

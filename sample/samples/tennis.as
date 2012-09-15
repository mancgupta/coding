//----------------------------------------------------------------------
//Symbol 15 MovieClip Frame 14
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 275 MovieClip Frame 13
//----------------------------------------------------------------------
    stop();
    cnt = 0;
    onenterframe = function () {
        cnt++;
        if (cnt < 30) {
            return(undefined);
        }
        delete onenterframe;
        gotoandstop ("inplay");
        _parent.after_score();
    };
﻿
//----------------------------------------------------------------------
//Symbol 293 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(10);
}
on (release) {
    on_click(10);
}
﻿
//----------------------------------------------------------------------
//Symbol 265 MovieClip Frame 1
//----------------------------------------------------------------------
    pname0 = _parent._parent.pname[0];
    pname1 = _parent._parent.pname[1];
    gpoint0 = _parent._parent.gpoint[0];
    gpoint1 = _parent._parent.gpoint[1];
 
﻿
//----------------------------------------------------------------------
//Symbol 31 MovieClip Frame 1
//----------------------------------------------------------------------
    stop();
    _parent.mcBGM.gotoandstop("title");
 
﻿
//----------------------------------------------------------------------
//Symbol 295 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(12);
}
on (release) {
    on_click(12);
}
﻿
//----------------------------------------------------------------------
//Symbol 298 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(15);
}
on (release) {
    on_click(15);
}
﻿
//----------------------------------------------------------------------
//Symbol 23 Button
//----------------------------------------------------------------------
on (release) {
    select = 0;
    nextframe();
}
﻿
//----------------------------------------------------------------------
//Symbol 122 MovieClip Frame 21
//----------------------------------------------------------------------
    _parent._parent.start_wait(1);
﻿
//----------------------------------------------------------------------
//Symbol 275 MovieClip Frame 2
//----------------------------------------------------------------------
    stop();
﻿
//----------------------------------------------------------------------
//Symbol 15 MovieClip Frame 27
//----------------------------------------------------------------------
    stop();
﻿
//----------------------------------------------------------------------
//Symbol 150 MovieClip Frame 8
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 155 MovieClip Frame 1
//----------------------------------------------------------------------
    stop();
﻿
//----------------------------------------------------------------------
//Symbol 352 MovieClip Frame 7
//----------------------------------------------------------------------
    stop();
    match_mode = 0;
 
﻿
//----------------------------------------------------------------------
//Symbol 50 MovieClip Frame 13
//----------------------------------------------------------------------
    stop();
    _parent.after_space();
﻿
//----------------------------------------------------------------------
//Symbol 275 MovieClip Frame 25
//----------------------------------------------------------------------
    function after_space() {
        _parent.after_match();
    }
    stop();
    mcSpace.gotoandstop(1);
 
﻿
//----------------------------------------------------------------------
//Symbol 250 MovieClip Frame 8
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 351 MovieClip Frame 1
//----------------------------------------------------------------------
    stop();
    cnt = 0;
    onenterframe = function () {
        cnt++;
        if (cnt > 30) {
            delete onenterframe;
            nextframe();
        }
    };
 
﻿
//----------------------------------------------------------------------
//Symbol 297 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(14);
}
on (release) {
    on_click(14);
}
﻿
//----------------------------------------------------------------------
//Symbol 54 MovieClip Frame 1
//----------------------------------------------------------------------
    stop();
    cnt = 0;
    onenterframe = function () {
        cnt++;
        if (cnt < 8) {
            return(undefined);
        }
        cnt = 0;
        if (_visible) {
            _visible  = false;
        } else {
            _visible  = true;
        }
    };
 
﻿
//----------------------------------------------------------------------
//Symbol 352 MovieClip Frame 34
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 352 MovieClip Frame 24
//----------------------------------------------------------------------
    function after_match() {
        kaisen++;
        if (kaisen > 3) {
            gotoandstop ("ending");
        } else {
            gotoandstop ("tournament");
        }
    }
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 292 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(9);
}
on (release) {
    on_click(9);
}
﻿
//----------------------------------------------------------------------
//Symbol 15 MovieClip Frame 32
//----------------------------------------------------------------------
    stop();
﻿
//----------------------------------------------------------------------
//Symbol 31 MovieClip Frame 2
//----------------------------------------------------------------------
    stop();
    _parent.mcBGM.gotoandstop("title_end");
    switch (select) {
        case 0 : 
            _parent.gotoandstop("edit");
            break;
        case 1 : 
            _parent.gotoandstop("tournament_init");
            break;
        case 2 : 
            geturl ("http://www.gamedesign.jp/");
    }
﻿
//----------------------------------------------------------------------
//Symbol 286 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(3);
}
on (release) {
    on_click(3);
}
﻿
//----------------------------------------------------------------------
//Symbol 352 MovieClip Frame 2
//----------------------------------------------------------------------
    function tdat_shuffle(pn) {
        user_player = pn;
        var tmp;
        if (pn > 0) {
            tmp = eval ("tdat" + pn);
            this["tdat" + pn] = tdat0;
            tdat0 = tmp;
        }
        i = 1;
        while (i < 16) {
            r = 1 + math.floor(math.random() * 15);
            tmp = eval ("tdat" + i);
            this["tdat" + i] = eval ("tdat" + r);
            this["tdat" + r] = tmp;
            i++;
        }
    }
    stop();
    pname = ["YOU", "COM"];
    player_data = [[5, 3, 6, 4, 0, 0], [4, 5, 4, 5, 5, 0]];
    tdat0 = "787765SELES";
    tdat1 = "989520VENUS";
    tdat2 = "567420DOKICI";
    tdat3 = "687789CHRIS";
    tdat4 = "346430ANNA";
    tdat5 = "768524CLIJSTER";
    tdat6 = "979746GRAF";
    tdat7 = "887657SABATINI";
    tdat8 = "465999SANCHEZ";
    tdat9 = "364735DATEKIMI";
    tdat10 = "878620DAVENPO";
    tdat11 = "677999NAVRATIL";
    tdat12 = "786879HINGIS";
    tdat13 = "467338PIERCE";
    tdat14 = "567350SHARAPO";
    tdat15 = "466698NOVOTNA";
 
﻿
//----------------------------------------------------------------------
//Symbol 287 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(4);
}
on (release) {
    on_click(4);
}
﻿
//----------------------------------------------------------------------
//Symbol 253 MovieClip Frame 1
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 275 MovieClip Frame 19
//----------------------------------------------------------------------
    function after_space() {
        _parent.after_game_winner();
    }
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 153 MovieClip Frame 1
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 275 MovieClip Frame 8
//----------------------------------------------------------------------
    stop();
    cnt = 0;
    onenterframe = function () {
        cnt++;
        if (cnt < 30) {
            return(undefined);
        }
        delete onenterframe;
        _parent.start_score();
    };
 
﻿
//----------------------------------------------------------------------
//Frame 2
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 222 MovieClip Frame 21
//----------------------------------------------------------------------
    _parent._parent.start_wait(0);
﻿
//----------------------------------------------------------------------
//Symbol 25 Button
//----------------------------------------------------------------------
on (release) {
    geturl ("http://www.gamedesign.jp/");
}
﻿
//----------------------------------------------------------------------
//Symbol 351 MovieClip Frame 8
//----------------------------------------------------------------------
    stop();
    mcMes.mes0 = _parent.result_txt[0];
    mcMes.mes1 = _parent.result_txt[1];
    mcMes.mes2 = _parent.result_txt[2];
    mcMes.mes3 = _parent.result_txt[3];
    mcMes.mes0 = "1st MATCH";
    stat = 0;
    lap = 0;
    onenterframe = function () {
        switch (stat) {
            case 0 : 
                switch (lap) {
                    case 0 : 
                        mcMes.mes0 = "1st MATCH";
                        mcMes.mes1 = _parent.result_txt[0];
                        break;
                    case 1 : 
                        mcMes.mes0 = "2nd MATCH";
                        mcMes.mes1 = _parent.result_txt[1];
                        break;
                    case 2 : 
                        mcMes.mes0 = "SEMI FINAL";
                        mcMes.mes1 = _parent.result_txt[2];
                        break;
                    case 3 : 
                        mcMes.mes0 = "FINAL MATCH";
                        mcMes.mes1 = _parent.result_txt[3];
                        break;
                    case 4 : 
                        mcMes.mes0 = "Thank you";
                        mcMes.mes1 = "for playing!";
                        break;
                    case 5 : 
                        mcMes.mes0 = "Created by";
                        mcMes.mes1 = "GAMEDESIGN";
                }
                mcMes._y = 380;
                stat = 1;
                break;
            case 1 : 
                mcMes._y--;
                if (lap == 5) {
                    if (mcMes._y < 260) {
                        delete onenterframe;
                        nextframe();
                    }
                }
                if (mcMes._y >= 140) { 
                    break;
                }
                stat = 0;
                lap++;
        }
    };
 
﻿
//----------------------------------------------------------------------
//Symbol 288 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(5);
}
on (release) {
    on_click(5);
}
﻿
//----------------------------------------------------------------------
//Symbol 50 MovieClip Frame 1
//----------------------------------------------------------------------
    stop();
    onkeydown = function () {
        if (key.getcode() == 32) {
            delete onkeydown;
            gotoandplay (2);
        }
    };
    key.addlistener(this);
 
﻿
//----------------------------------------------------------------------
//Symbol 294 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(11);
}
on (release) {
    on_click(11);
}
﻿
//----------------------------------------------------------------------
//Symbol 351 MovieClip Frame 7
//----------------------------------------------------------------------
    stop();
    cnt = 0;
    onenterframe = function () {
        cnt++;
        if (cnt > 30) {
            delete onenterframe;
            nextframe();
        }
    };
 
﻿
//----------------------------------------------------------------------
//Symbol 204 MovieClip Frame 21
//----------------------------------------------------------------------
    _parent._parent.start_wait(0);
﻿
//----------------------------------------------------------------------
//Symbol 351 MovieClip Frame 9
//----------------------------------------------------------------------
    function after_space() {
        geturl ("http://www.gamedesign.jp/");
    }
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 290 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(7);
}
on (release) {
    on_click(7);
}
﻿
//----------------------------------------------------------------------
//Symbol 352 MovieClip Frame 1
//----------------------------------------------------------------------
 
﻿
//----------------------------------------------------------------------
//Symbol 15 MovieClip Frame 19
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 351 MovieClip Frame 2
//----------------------------------------------------------------------
    stop();
    mcCongra._alpha = 100;
    onenterframe = function () {
        mcCongra._alpha = mcCongra._alpha - 1;
        if (mcCongra._alpha <= 0) {
            delete onenterframe;
            nextframe();
        }
    };
 
﻿
//----------------------------------------------------------------------
//Symbol 281 Button
//----------------------------------------------------------------------
on (release) {
    end_match_quit();
}
﻿
//----------------------------------------------------------------------
//Symbol 296 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(13);
}
on (release) {
    on_click(13);
}
﻿
//----------------------------------------------------------------------
//Symbol 275 MovieClip Frame 30
//----------------------------------------------------------------------
    function after_space() {
        _parent.after_match();
    }
 
﻿
//----------------------------------------------------------------------
//Symbol 15 MovieClip Frame 2
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 351 MovieClip Frame 3
//----------------------------------------------------------------------
    stop();
    cnt = 0;
    onenterframe = function () {
        cnt++;
        if (cnt > 200) {
            delete onenterframe;
            nextframe();
        }
    };
﻿
//----------------------------------------------------------------------
//Symbol 351 MovieClip Frame 6
//----------------------------------------------------------------------
    stop();
    cnt = 0;
    onenterframe = function () {
        cnt++;
        if (cnt > 30) {
            delete onenterframe;
            nextframe();
        }
    };
 
﻿
//----------------------------------------------------------------------
//Symbol 289 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(6);
}
on (release) {
    on_click(6);
}
﻿
//----------------------------------------------------------------------
//Symbol 282 MovieClip Frame 1
//----------------------------------------------------------------------
    function init_game() {
        serve_pos = 1;
        play_winner = -1;
        fault_cnt = 0;
        point = [0, 0];
        score_txt = (pname[server] + " 0 - 0 ") + pname[receiver];
        init_play();
    }
    function init_play() {
        rally_cnt = 0;
        play_result = 0;
        mcMes.gotoandstop("inplay");
        var i = 0;
        while (i < 2) {
            var mc = eval ("mcPlayer" + i);
            mc.vy = COURT_H + 20;
            if (i == 1) {
                mc.vy = mc.vy * -1;
            }
            if (server == i) {
                mc.vx = serve_pos * 20;
                start_serve(i);
            } else {
                mc.vx = ((serve_pos * (-COURT_W)) * 2) / 3;
                mc.stat = PS_WAIT;
                mc.gotoandstop("wait");
                mc.wm = WM_WAIT;
            }
            if (server == 1) {
                mc.vx = mc.vx * -1;
            }
            player_position(i);
            mc.net_flg = 0;
            i++;
        }
        init_ball();
        debug_txt = "";
    }
    function user_action() {
        mc = mcPlayer0;
        switch (mc.stat) {
            case PS_SERVE : 
                check_pad();
                if (pad_trig) {
                    start_toss(0);
                }
                return;
            case PS_TOSS : 
                check_pad();
                mc.cnt++;
                if (mc.cnt > 8) {
                    if (pad_trig) {
                        start_stroke_user(0);
                    }
                }
                if (mc.cnt == 7) {
                    start_toss_ball(0);
                }
                return;
            case PS_STROKE : 
                mc.cnt++;
                if (mc.cnt == 3) {
                    if (check_hit(0)) {
                        set_ball_dest_user();
                        if (mcPlayer1.stat == PS_WAIT) {
                            mcPlayer1.stat = PS_FREEZE;
                            mcPlayer1.cnt = 0;
                            mcPlayer1.gotoandstop("wait");
                        }
                    }
                }
                return;
            case PS_WAIT : 
                check_pad();
                if ((pad_vart == 0) && (pad_hori == 0)) {
                    mc.gotoandstop("wait");
                    move_cnt = 0;
                } else {
                    var a = mc.footwork;
                    mc.vx = mc.vx + (pad_hori * a);
                    mc.vy = mc.vy + (pad_vart * a);
                    if (mc.vy <= 20) {
                        mc.vy = 20;
                    }
                    player_position(0);
                    if (pad_hori < 0) {
                        mc.gotoandstop("left");
                    } else {
                        mc.gotoandstop("right");
                    }
                }
                if (!pad_trig) { 
                    break;
                }
                start_stroke_user(0);
        }
    }
    function check_pad() {
        pad_vart = 0;
        if (keydata[40]) {
            pad_vart = 1;
        }
        if (keydata[38]) {
            pad_vart = -1;
        }
        pad_hori = 0;
        if (keydata[37]) {
            pad_hori = -1;
        }
        if (keydata[39]) {
            pad_hori = 1;
        }
        pad_trig = keydata[32];
    }
    function start_serve(pn) {
        var mc = eval ("mcPlayer" + pn);
        mc.stat = PS_SERVE;
        mc.cnt = 0;
        mc.gotoandstop("serve");
    }
    function start_toss(pn) {
        var mc = eval ("mcPlayer" + pn);
        mc.stat = PS_TOSS;
        mc.gotoandstop("toss");
        mc.cnt = 0;
    }
    function start_stroke_user(pn) {
        var mc = mcPlayer0;
        mc.stat = PS_STROKE;
        mc.cnt = 0;
        var nx = (mcBall.vx + (mcBall.ax * 2));
        if (((mcBall.vh > 70) && (nx > (mc.vx + HIT_X1_SMASH))) && (nx < (mc.vx + HIT_X2_SMASH))) {
            mc.stroke_type = ST_SMASH;
            mc.hit_x1 = HIT_X1_SMASH;
            mc.hit_x2 = HIT_X2_SMASH;
            mc.gotoandstop("smash");
        } else if ((mcBall.vx + (mcBall.ax * 3)) < mc.vx) {
            mc.stroke_type = ST_BACK;
            mc.hit_x1 = HIT_X1_BACK;
            mc.hit_x2 = HIT_X2_BACK;
            mc.gotoandstop("back");
        } else {
            mc.stroke_type = ST_FORE;
            mc.hit_x1 = HIT_X1_FORE;
            mc.hit_x2 = HIT_X2_FORE;
            mc.gotoandstop("fore");
        }
        mc.hit_y1 = HIT_Y1;
        mc.hit_y2 = HIT_Y2;
    }
    function check_hit(pn) {
        var mc = eval ("mcPlayer" + pn);
        if (mcBall.vx < (mc.vx + mc.hit_x1)) {
            return(0);
        }
        if (mcBall.vx > (mc.vx + mc.hit_x2)) {
            return(0);
        }
        if (mcBall.vy < (mc.vy + mc.hit_y1)) {
            return(0);
        }
        if (mcBall.vy > (mc.vy + mc.hit_y2)) {
            return(0);
        }
        if (mcBall.vh > HIT_Z) {
            return(0);
        }
        return(1);
    }
    function set_ball_dest_user() {
        if (mcBall.side == 0) {
            return(undefined);
        }
        check_pad();
        var _local6 = 1;
        if (pad_hori < 0) {
            _local6 = 0;
        }
        if (pad_hori > 0) {
            _local6 = 2;
        }
        var _local5 = 1;
        if (pad_vart < 0) {
            _local5 = 0;
        }
        if (pad_vart > 0) {
            _local5 = 2;
        }
        var _local1;
        var _local2;
        var _local3;
        var _local7;
        if (rally_cnt == 0) {
            if (serve_pos > 0) {
                _local1 = -COURT_W;
                _local2 = 0;
            } else {
                _local1 = 0;
                _local2 = COURT_W;
            }
            _local3 = -SERVE_H;
            _local7 = (-SERVE_H) / 2;
        } else {
            _local1 = -COURT_W;
            _local2 = COURT_W;
            _local3 = -COURT_H;
            _local7 = (-COURT_H) / 3;
        }
        var _local9 = (_local2 - _local1) / 3;
        var _local8 = (_local7 - _local3) / 3;
        var _local11 = (_local1 + (_local9 * _local6)) + (math.random() * _local9);
        var _local10 = (_local3 + (_local8 * _local5)) + (math.random() * _local8);
        var _local4 = mc.forehand;
        if (mcPlayer0.stroke_type == ST_BACK) {
            _local4 = mc.backhand;
        }
        if (mcPlayer0.stroke_type == ST_SMASH) {
            _local4 = mc.serve;
        }
        start_move_ball(_local11, _local10, 0, _local4);
    }
    function start_wait(pn) {
        var mc = eval ("mcPlayer" + pn);
        if ((mc.stat == PS_STROKE) && (mc.stroke_type == ST_SMASH)) {
            var ay = -20;
            if (pn == 1) {
                ay = ay * -1;
            }
            mc.vy = mc.vy + ay;
            if ((pn == 0) && (mc.vy < 0)) {
                mc.vy = 0;
            }
            if ((pn == 1) && (mc.vy > 0)) {
                mc.vy = 0;
            }
            player_position(pn);
        }
        mc.stat = PS_WAIT;
        mc.gotoandstop("wait");
        if ((pn == 1) && (mcBall.vy < mc.vy)) {
            mc.stat = PS_AFTER;
            mc.gotoandstop("win");
        }
        if (mc.net_flg == 0) {
            if (mc.netplay > (math.random() * 20)) {
                mc.net_flg = 1;
            }
        }
        mc.wm = WM_MOVE;
        mc.dest_x = 0;
        mc.dest_y = -COURT_H;
        if (mc.net_flg) {
            mc.dest_x = mcBall.dx / 3;
            mc.dest_y = -150;
        }
    }
    function move_enemy() {
        var mc = mcPlayer1;
        switch (mc.stat) {
            case PS_SERVE : 
                mc.cnt++;
                if (mc.cnt > 10) {
                    start_toss(1);
                }
                return;
            case PS_TOSS : 
                mc.cnt++;
                if (mc.cnt == 7) {
                    start_toss_ball(1);
                }
                if (mc.cnt > 22) {
                    start_stroke_com(1);
                }
                return;
            case PS_WAIT : 
                if (mc.wm == WM_MOVE) {
                    var foot = mc.footwork;
                    var f = 0;
                    var lr = 0;
                    if (mc.vy < (mc.dest_y - 10)) {
                        mc.vy = mc.vy + foot;
                    } else if (mc.vy > (mc.dest_y + 10)) {
                        mc.vy = mc.vy - foot;
                    } else {
                        f++;
                    }
                    if (f == 0) {
                        if (mc.vx > 0) {
                            lr = 1;
                        } else {
                            lr = -1;
                        }
                    }
                    if (mc.vx < (mc.dest_x - 10)) {
                        mc.vx = mc.vx + foot;
                        mc.gotoandstop("left");
                        lr = -1;
                    } else if (mc.vx > (mc.dest_x + 10)) {
                        mc.vx = mc.vx - foot;
                        mc.gotoandstop("right");
                        lr = 1;
                    } else {
                        f++;
                    }
                    if (f == 2) {
                        mc.wm = WM_WAIT;
                        mc.gotoandstop("wait");
                    } else {
                        if (lr < 0) {
                            mc.gotoandstop("left");
                        }
                        if (lr > 0) {
                            mc.gotoandstop("right");
                        }
                    }
                    player_position(1);
                }
                if ((mcBall.vy + (mcBall.ay * 4)) < mc.vy) {
                    if (math.abs((mcBall.vx + (mcBall.ax * 4)) - mc.vx) < 60) {
                        start_stroke_com(1);
                    }
                }
                return;
            case PS_STROKE : 
                mc.cnt++;
                if (mc.cnt == 3) {
                    if (check_hit(1)) {
                        set_ball_dest_com();
                    }
                }
                return;
            case PS_FREEZE : 
                mc.cnt++;
                if (mc.cnt > 10) {
                    if (mc.vy > mcBall.dy) {
                        mc.dest_x = ((mcBall.ax / mcBall.ay) * (mc.vy - mcBall.vy)) + mcBall.vx;
                        mc.dest_y = mc.vy;
                    } else {
                        mc.dest_x = mcBall.dx + (mcBall.ax * 5);
                        mc.dest_y = mcBall.dy + (mcBall.ay * 5);
                    }
                    mc.stat = PS_WAIT;
                    mc.wm = WM_MOVE;
                }
                return;
        }
    }
    function start_stroke_com(pn) {
        var mc = eval ("mcPlayer" + pn);
        mc.stat = PS_STROKE;
        mc.cnt = 0;
        var nx = (mcBall.vx + (mcBall.ax * 2));
        if (((mcBall.vh > 70) && (nx > (mc.vx - HIT_X2_SMASH))) && (nx < (mc.vx - HIT_X1_SMASH))) {
            mc.stroke_type = ST_SMASH;
            mc.hit_x1 = -HIT_X2_SMASH;
            mc.hit_x2 = -HIT_X1_SMASH;
            mc.gotoandstop("smash");
        } else if ((mcBall.vx + (mcBall.ax * 3)) > mc.vx) {
            mc.stroke_type = ST_BACK;
            mc.hit_x1 = -HIT_X2_BACK;
            mc.hit_x2 = -HIT_X1_BACK;
            mc.gotoandstop("back");
        } else {
            mc.stroke_type = ST_FORE;
            mc.hit_x1 = -HIT_X2_FORE;
            mc.hit_x2 = -HIT_X1_FORE;
            mc.gotoandstop("fore");
        }
        mc.hit_y1 = -HIT_Y2;
        mc.hit_y2 = -HIT_Y1;
    }
    function set_ball_dest_com() {
        var cx = math.floor(math.random() * 3);
        var cy = math.floor(math.random() * 3);
        var x1;
        var x2;
        var y1;
        var y2;
        if (rally_cnt == 0) {
            if (serve_pos > 0) {
                x1 = -COURT_W;
                x2 = 0;
            } else {
                x1 = 0;
                x2 = COURT_W;
            }
            y1 = -SERVE_H;
            y2 = (-SERVE_H) / 2;
        } else {
            if (mcPlayer1.tech > (math.random() * 10)) {
                if (mcPlayer0.vx < 0) {
                    cx = 0;
                } else {
                    cx = 2;
                }
            }
            if (mcPlayer1.net_flg) {
                cy = math.floor(math.random() * 2);
            }
            x1 = -COURT_W;
            x2 = COURT_W;
            y1 = -COURT_H;
            y2 = (-COURT_H) / 3;
        }
        var w = ((x2 - x1) / 3);
        var h = ((y2 - y1) / 3);
        var x = ((x1 + (w * cx)) + (math.random() * w));
        var y = ((y1 + (h * cy)) + (math.random() * h));
        x = x * -1;
        y = y * -1;
        mc = mcPlayer1;
        var s = mc.forehand;
        if (mcPlayer1.stroke_type == ST_BACK) {
            s = mc.backhand;
        }
        if (mcPlayer1.stroke_type == ST_SMASH) {
            s = mc.serve;
        }
        start_move_ball(x, y, 1, s);
    }
    function player_position(n) {
        var mc = eval ("mcPlayer" + n);
        var per = (1 + ((mc.vy / COURT_H) / 10));
        var x = (mc.vx * per);
        var y = (mc.vy / 2);
        mc._x = SCREEN_OX + x;
        mc._y = SCREEN_OY + y;
        mc._xscale = 60 * per;
        mc._yscale = 60 * per;
        var mc2 = eval ("mcShadow" + n);
        mc2._x = mc._x;
        mc2._y = mc._y;
    }
    function init_ball() {
        var mc = eval ("mcPlayer" + server);
        mcBall.ax = 0;
        mcBall.ay = 0;
        mcBall.vx = mc.vx;
        mcBall.vy = mc.vy;
        mcBall.vh = 0;
        mcBall.up = 0;
        mcBall.down = 0;
        mcBall.side = 0;
        if (server == 0) {
            mcBall.side = 1;
        }
        mcBall.area = 0;
        if (server == 1) {
            mcBall.area = 1;
        }
        mcBall.moving = 0;
        mcBall._visible = false;
        mcBallShadow._visible = false;
    }
    function start_toss_ball(pn) {
        var mc = eval ("mcPlayer" + pn);
        mcBall.ax = 0;
        mcBall.ay = 0;
        var ax = 10;
        if (pn == 1) {
            ax = ax * -1;
        }
        mcBall.vx = mc.vx + ax;
        mcBall.vy = mc.vy;
        mcBall.vh = TOSS_H;
        mcBall.up = 10;
        mcBall.down = 0;
        mcBall.side = 0;
        if (pn == 0) {
            mcBall.side = 1;
        }
        mcBall.bound = 0;
        mcBall.moving = 1;
        mcBall._visible = true;
        mcBallShadow._visible = true;
    }
    function start_move_ball(dx, dy, side, max_speed) {
        if ((rally_cnt == 1) && (mcBall.bound == 0)) {
            set_result(RESULT_VOLLEY);
        }
        mcBall.side = side;
        mcBall.dx = dx;
        mcBall.dy = dy;
        var _local3 = mcBall.dx - mcBall.vx;
        var _local2 = mcBall.dy - mcBall.vy;
        var _local4 = math.sqrt((_local3 * _local3) + (_local2 * _local2));
        i = 0;
        while (i < 5) {
            var _local1 = max_speed - (i * 4);
            if (check_hit_net(_local3, _local2, _local1, _local4) == 1) {
                break;
            }
            i++;
        }
        var _local5 = _local4 / _local1;
        var _local7 = ((_local5 * (_local5 - 1)) * GRAVITY) / 2;
        mcBall.ax = _local3 / _local5;
        mcBall.ay = _local2 / _local5;
        mcBall.up = (_local7 - mcBall.vh) / _local5;
        mcBall.down = 0;
        mcBall.bound = 0;
        rally_cnt++;
        sndHit.start();
    }
    function check_hit_net(sx, sy, speed, dt) {
        var _local6 = dt / speed;
        var _local7 = ((_local6 * (_local6 - 1)) * GRAVITY) / 2;
        var _local8 = sx / _local6;
        var _local4 = sy / _local6;
        var _local5 = (_local7 - mcBall.vh) / _local6;
        var _local3 = 0;
        var _local2 = mcBall.vy;
        var _local1 = mcBall.vh;
        while (true) {
            _local1 = _local1 + (_local5 - _local3);
            _local3 = _local3 + GRAVITY;
            _local2 = _local2 + _local4;
            if (_local1 < 0) {
                return(0);
            }
            if ((mcBall.side == 0) && (_local2 < 0)) {
                if (_local1 > (NET_H + 10)) {
                    return(1);
                }
                return(0);
            }
            if ((mcBall.side == 1) && (_local2 > 0)) {
                if (_local1 > (NET_H + 10)) {
                    return(1);
                }
                return(0);
            }
        }
    }
    function move_ball() {
        if (mcBall.moving != 1) {
            return(undefined);
        }
        mcBall.vh = mcBall.vh + (mcBall.up - mcBall.down);
        if (mcBall.vh < 0) {
            mcBall.up = ((mcBall.down - mcBall.up) * 2) / 3;
            if (mcBall.up < 1.3) {
                mcBall.vh = 0;
                mcBall.moving = 0;
            }
            mcBall.down = 0;
            mcBall.vh = 0;
            mcBall.ax = (mcBall.ax * 3) / 5;
            mcBall.ay = (mcBall.ay * 3) / 5;
            mcBall.bound++;
            mcBall.vx = mcBall.vx + mcBall.ax;
            mcBall.vy = mcBall.vy + mcBall.ay;
            draw_ball();
            mcBound._x = mcBall._x;
            mcBound._y = mcBall._y;
            mcBound.gotoandstop(2);
            if (mcBall.bound == 1) {
                if (rally_cnt <= 1) {
                    if (check_out_serve()) {
                        set_result(RESULT_FAULT);
                    }
                } else if (check_out()) {
                    set_result(RESULT_OUT);
                }
            } else if (mcBall.bound == 2) {
                set_result(RESULT_MISS);
            }
            sndBound.start();
            draw_ball();
        } else {
            mcBall.down = mcBall.down + GRAVITY;
            mcBall.vx = mcBall.vx + mcBall.ax;
            mcBall.vy = mcBall.vy + mcBall.ay;
            draw_ball();
        }
    }
    function draw_ball() {
        var _local1 = 1 + ((mcBall.vy / COURT_H) / 10);
        var _local3 = mcBall.vx * _local1;
        var _local2 = mcBall.vy / 2;
        var _local4 = mcBall.vh * _local1;
        mcBall._x = SCREEN_OX + _local3;
        mcBall._y = (SCREEN_OY + _local2) - _local4;
        mcBall._xscale = 100 * _local1;
        mcBall._yscale = 100 * _local1;
        mcBallShadow._x = SCREEN_OX + _local3;
        mcBallShadow._y = SCREEN_OY + _local2;
    }
    function check_out_serve() {
        var _local2;
        var _local4;
        var _local1;
        var _local3;
        if (server == 0) {
            if (serve_pos > 0) {
                _local2 = -COURT_W;
                _local1 = 0;
            } else {
                _local2 = 0;
                _local1 = COURT_W;
            }
            _local4 = -SERVE_H;
            _local3 = 0;
        } else {
            if (serve_pos > 0) {
                _local2 = 0;
                _local1 = COURT_W;
            } else {
                _local2 = -COURT_W;
                _local1 = 0;
            }
            _local4 = 0;
            _local3 = SERVE_H;
        }
        if (mcBall.vx < _local2) {
            return(1);
        }
        if (mcBall.vx > _local1) {
            return(1);
        }
        if (mcBall.vy < _local4) {
            return(1);
        }
        if (mcBall.vy > _local3) {
            return(1);
        }
        return(0);
    }
    function check_out() {
        var _local4;
        var _local2;
        var _local3;
        var _local1;
        _local4 = -COURT_W;
        _local3 = COURT_W;
        if (mcBall.side == 0) {
            _local2 = -COURT_H;
            _local1 = 0;
        } else {
            _local2 = 0;
            _local1 = COURT_H;
        }
        if (mcBall.vx < _local4) {
            return(1);
        }
        if (mcBall.vx > _local3) {
            return(1);
        }
        if (mcBall.vy < _local2) {
            return(1);
        }
        if (mcBall.vy > _local1) {
            return(1);
        }
        return(0);
    }
    function set_result(res) {
        if (play_result > 0) {
            return(undefined);
        }
        play_result = res;
        switch (res) {
            case RESULT_FAULT : 
                fault_cnt++;
                if (fault_cnt == 1) {
                    mcMes.mes_txt = "FAULT";
                } else {
                    mcMes.mes_txt = "DOUBLE FAULT";
                    play_winner = ((server == 0) ? 1 : 0);
                }
                mcMes.gotoandstop("mes");
                break;
            case RESULT_OUT : 
                mcMes.mes_txt = "OUT";
                play_winner = ((mcBall.side == 0) ? 1 : 0);
                mcMes.gotoandstop("mes");
                break;
            case RESULT_MISS : 
                if (_parent.match_mode == 1) {
                    sndApp.start();
                }
                play_winner = mcBall.side;
                start_score();
                break;
            case RESULT_VOLLEY : 
                play_winner = server;
                start_score();
        }
    }
    function start_score() {
        if (play_winner < 0) {
            init_play();
            return(undefined);
        }
        point[play_winner]++;
        if (point[play_winner] > 3) {
            if (point[0] == point[1]) {
                score_txt = "DEUCE";
                mcMes.mes_txt = score_txt;
                mcMes.gotoandstop("score");
            } else if (math.abs(point[0] - point[1]) <= 1) {
                score_txt = "Advantage " + pname[play_winner];
                mcMes.mes_txt = "Advantage " + pname[play_winner];
                mcMes.gotoandstop("score");
            } else {
                game_winner = play_winner;
                gpoint[game_winner]++;
                mcMes.mes_txt = "Game won by " + pname[play_winner];
                mcMes.gotoandstop("game");
                mcPlayer0.stat = PS_AFTER;
                mcPlayer0.gotoandstop("win");
                return(undefined);
            }
        } else {
            var _local3 = point[server];
            var _local2 = point[receiver];
            var _local1 = [0, 15, 30, 40];
            score_txt = (((((pname[server] + " ") + _local1[_local3]) + " - ") + _local1[_local2]) + " ") + pname[receiver];
            mcMes.mes_txt = (_local1[_local3] + " - ") + _local1[_local2];
            mcMes.gotoandstop("score");
        }
        if (play_winner == 1) {
            mcPlayer1.gotoandstop("win");
            mcPlayer1.stat = PS_AFTER;
        } else {
            mcPlayer1.gotoandstop("lose");
            mcPlayer1.stat = PS_AFTER;
        }
    }
    function after_score() {
        fault_cnt = 0;
        play_winner = -1;
        serve_pos = ((serve_pos == 1) ? -1 : 1);
        init_play();
    }
    function after_game_winner() {
        if ((gpoint[game_winner] >= 3) && (math.abs(gpoint[0] - gpoint[1]) > 1)) {
            if (_parent.match_mode == 1) {
                sndApp2.start();
            }
            score_txt = "";
            if (gpoint[0] > gpoint[1]) {
                match_winner = 0;
                mcMes.gotoandstop("win");
            } else {
                match_winner = 1;
                mcMes.gotoandplay("lose");
            }
        } else {
            mcMes.gotoandstop("inplay");
            server = ((server == 0) ? 1 : 0);
            receiver = ((server == 0) ? 1 : 0);
            init_game();
        }
    }
    function after_match() {
        if (_parent.match_mode == 0) {
            _parent.gotoandstop("title");
        } else if (match_winner == 0) {
            _parent.result_txt[_parent.kaisen] = (((((pname[0] + " ") + gpoint[0]) + " - ") + gpoint[1]) + " ") + pname[1];
            _parent.after_match();
        } else {
            _parent.gotoandstop("title");
        }
    }
    function end_match_quit() {
        _parent.gotoandstop("title");
    }
    stop();
    sndBound = new sound();
    sndBound.attachsound("Bound.wav");
    sndHit = new sound();
    sndHit.attachsound("Hit.wav");
    sndApp = new sound();
    sndApp.attachsound("app.wav");
    sndApp2 = new sound();
    sndApp2.attachsound("app2.wav");
    COURT_W = 180;
    COURT_H = 360;
    SERVE_H = 200;
    SCREEN_OX = 300;
    SCREEN_OY = 300;
    mcNet._y = SCREEN_OY;
    NET_H = 40;
    TOSS_H = 50;
    GRAVITY = 0.8;
    PS_WAIT = 1;
    PS_MOVE = 2;
    PS_STROKE = 3;
    PS_SERVE = 4;
    PS_TOSS = 5;
    PS_FREEZE = 6;
    PS_AFTER = 7;
    ST_FORE = 1;
    ST_BACK = 2;
    ST_SMASH = 3;
    HIT_X1_FORE = -10;
    HIT_X2_FORE = 60;
    HIT_X1_BACK = -60;
    HIT_X2_BACK = 10;
    HIT_X1_SMASH = -30;
    HIT_X2_SMASH = 50;
    HIT_Y1 = -120;
    HIT_Y2 = 80;
    HIT_Z = 120;
    WM_WAIT = 1;
    WM_MOVE = 2;
    RESULT_FAULT = 1;
    RESULT_OUT = 2;
    RESULT_MISS = 3;
    RESULT_VOLLEY = 4;
    pname = new array(2);
    i = 0;
    while (i < 2) {
        pname[i] = _parent.pname[i];
        mc = eval ("mcPlayer" + i);
        mc.forehand = 20 + (1 * _parent.player_data[i][0]);
        mc.backhand = 20 + (0.5 * _parent.player_data[i][1]);
        mc.serve = 30 + (3 * _parent.player_data[i][2]);
        mc.footwork = 6 + (0.3 * _parent.player_data[i][3]);
        mc.netplay = _parent.player_data[i][4];
        mc.tech = _parent.player_data[i][5];
        i++;
    }
    server = 0;
    receiver = 1;
    gpoint = [0, 0];
    init_game();
    onenterframe = function () {
        user_action();
        move_enemy();
        move_ball();
    };
    keydata = new array();
    onkeydown = function () {
        var _local1 = key.getcode();
        if (_local1 != -1) {
            keydata[_local1] = true;
        }
    };
    onkeyup = function () {
        var _local1 = key.getcode();
        if (_local1 != -1) {
            keydata[_local1] = false;
        }
    };
    key.addlistener(this);
 
﻿
//----------------------------------------------------------------------
//Symbol 275 MovieClip Frame 60
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 15 MovieClip Frame 7
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 352 MovieClip Frame 20
//----------------------------------------------------------------------
    stop();
    kaisen = 0;
    match_mode = 1;
    result_txt = new array();
 
﻿
//----------------------------------------------------------------------
//Symbol 51 MovieClip Frame 1
//----------------------------------------------------------------------
    function after_space() {
        _parent.pname[0] = "YOU";
        _parent.pname[1] = "COM";
        i = 0;
        while (i < 2) {
            j = 0;
            while (j < 4) {
                mc = eval (("mcNum" + i) + j);
                _parent.player_data[i][j] = mc.num;
                j++;
            }
            i++;
        }
        _parent.mcBGM.gotoandstop("start_end");
        _parent.gotoandstop("play");
    }
    edit_ok = 1;
    i = 0;
    while (i < 2) {
        j = 0;
        while (j < 4) {
            _parent.player_data[i][j] = math.floor((((math.random() * 10) + (math.random() * 10)) + (math.random() * 10)) / 3);
            mc = eval (("mcNum" + i) + j);
            mc.num = _parent.player_data[i][j];
            mc.update();
            j++;
        }
        i++;
    }
    _parent.mcBGM.gotoandstop("start");
 
﻿
//----------------------------------------------------------------------
//Symbol 239 MovieClip Frame 17
//----------------------------------------------------------------------
    _parent._parent.start_wait(0);
﻿
//----------------------------------------------------------------------
//Frame 1
//----------------------------------------------------------------------
    stop();
    this.onenterframe = function () {
        if (this.getbytestotal() <= this.getbytesloaded()) {
            delete this.onenterframe;
            nextframe();
        } else {
            var per = math.floor((this.getbytesloaded() / this.getbytestotal()) * 100);
            load_txt = per + "%";
            var n = math.floor(per / 10);
            i = 0;
            while (i < 10) {
                var mc = eval ("mc" + i);
                if (i <= n) {
                    mc._visible = true;
                } else {
                    mc._visible = false;
                }
                i++;
            }
        }
    };
 
﻿
//----------------------------------------------------------------------
//Symbol 337 MovieClip Frame 1
//----------------------------------------------------------------------
    function make_line(pn) {
        mcLine.linestyle(6, 16750848, 100);
        var _local2 = 160;
        if (pn >= 8) {
            _local2 = 440;
        }
        var _local1 = 150 + ((pn % 8) * 40);
        var _local3 = 40;
        if (pn >= 8) {
            _local3 = -40;
        }
        mcLine.moveto(_local2, _local1);
        _local2 = _local2 + _local3;
        mcLine.lineto(_local2, _local1);
        if (kaisen > 0) {
            if ((pn % 2) == 0) {
                _local1 = _local1 + 20;
            } else {
                _local1 = _local1 - 20;
            }
            mcLine.lineto(_local2, _local1);
            _local2 = _local2 + _local3;
            mcLine.lineto(_local2, _local1);
        }
        if (kaisen > 1) {
            if ((math.floor(pn / 2) % 2) == 0) {
                _local1 = _local1 + 40;
            } else {
                _local1 = _local1 - 40;
            }
            mcLine.lineto(_local2, _local1);
            _local2 = _local2 + _local3;
            mcLine.lineto(_local2, _local1);
        }
        if (kaisen > 2) {
            if ((math.floor(pn / 4) % 2) == 0) {
                _local1 = _local1 + 80;
            } else {
                _local1 = _local1 - 80;
            }
            mcLine.lineto(_local2, _local1);
            _local2 = _local2 + (_local3 / 4);
            mcLine.lineto(_local2, _local1);
        }
    }
    function after_space() {
        _parent.mcBGM.gotoandstop("start_end");
        s = _parent.tdat0;
        _parent.pname[0] = substring(s, 7, -1);
        i = 0;
        while (i < 6) {
            _parent.player_data[0][i] = number(s.charat(i));
            i++;
        }
        s = eval ("_parent.tdat" + oppo);
        _parent.pname[1] = substring(s, 7, -1);
        i = 0;
        while (i < 6) {
            _parent.player_data[1][i] = number(s.charat(i));
            i++;
        }
        _parent.gotoandstop("play");
    }
    stop();
    kaisen = _parent.kaisen;
    i = 0;
    while (i < 16) {
        s = eval ("_parent.tdat" + i);
        this["tname" + i] = s.substring(6);
        i++;
    }
    match_name = ["1st MATCH", "2nd MATCH", "SEMI FINAL", "FINAL MATCH"];
    match_txt = match_name[kaisen];
    a = 1;
    i = 0;
    while (i < kaisen) {
        a = a * 2;
        i++;
    }
    oppo = 1;
    max = -1;
    i = 0;
    while (i < a) {
        n = a + i;
        s = eval ("_parent.tdat" + n);
        v = 0;
        j = 0;
        while (j < 6) {
            if (j == 4) {
            } else {
                v = v + number(s.charat(j));
            }
            j++;
        }
        v = v + (math.random() * 20);
        if (v > max) {
            max = v;
            oppo = n;
        }
        i++;
    }
    make_line(0);
    make_line(oppo);
    vs_txt = ((substring(_parent.tdat0, 7, -1)) + " vs ") + (substring(eval ("_parent.tdat" + oppo), 7, -1));
    _parent.mcBGM.gotoandstop("start");
 
﻿
//----------------------------------------------------------------------
//Symbol 316 MovieClip Frame 1
//----------------------------------------------------------------------
    function on_over(pn) {
        s = eval ("_parent.tdat" + pn);
        var i = 0;
        while (i < 4) {
            mc = eval ("mcBar" + i);
            mc.num = number(s.charat(i));
            mc.update();
            mc._visible = true;
            i++;
        }
    }
    function on_click(pn) {
        _parent.mcBGM.gotoandstop("select_end");
        _parent.tdat_shuffle(pn);
        _parent.gotoandstop("tournament");
    }
    stop();
    edit_ok = 0;
    var i = 0;
    while (i < 4) {
        mc = eval ("mcBar" + i);
        mc.num = 0;
        mc.update();
        mc._visible = false;
        i++;
    }
    i = 0;
    while (i < 16) {
        s = eval ("_parent.tdat" + i);
        this["pname" + i] = s.substring(6);
        i++;
    }
    _parent.mcBGM.gotoandstop("select");
 
﻿
//----------------------------------------------------------------------
//Symbol 283 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(0);
}
on (release) {
    on_click(0);
}
﻿
//----------------------------------------------------------------------
//Symbol 139 MovieClip Frame 17
//----------------------------------------------------------------------
    _parent._parent.start_wait(1);
﻿
//----------------------------------------------------------------------
//Symbol 15 MovieClip Frame 1
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 104 MovieClip Frame 21
//----------------------------------------------------------------------
    _parent._parent.start_wait(1);
﻿
//----------------------------------------------------------------------
//Symbol 351 MovieClip Frame 4
//----------------------------------------------------------------------
    stop();
    mcCongra._alpha = 0;
    onenterframe = function () {
        mcCongra._alpha = mcCongra._alpha + 2;
        if (mcCongra._alpha >= 100) {
            delete onenterframe;
            gotoandplay(_currentframe + 1);
        }
    };
﻿
//----------------------------------------------------------------------
//Symbol 352 MovieClip Frame 12
//----------------------------------------------------------------------
    stop();
 
﻿
//----------------------------------------------------------------------
//Symbol 284 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(1);
}
on (release) {
    on_click(1);
}
﻿
//----------------------------------------------------------------------
//Symbol 24 Button
//----------------------------------------------------------------------
on (release) {
    select = 1;
    nextframe();
}
﻿
//----------------------------------------------------------------------
//Symbol 291 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(8);
}
on (release) {
    on_click(8);
}
﻿
//----------------------------------------------------------------------
//Symbol 37 MovieClip Frame 1
//----------------------------------------------------------------------
    function update() {
        mcBar._xscale = (num + 1) * 10;
        num_txt = num + 1;
    }
    stop();
    update();
    if (_parent.edit_ok == 1) {
        onpress = function () {
            var _local1 = math.floor(_xmouse / 20);
            if (_local1 < 0) {
                _local1 = 0;
            }
            if (_local1 > 9) {
                _local1 = 9;
            }
            num = _local1;
            update();
        };
    }
 
﻿
//----------------------------------------------------------------------
//Symbol 285 Button
//----------------------------------------------------------------------
on (rollOver) {
    on_over(2);
}
on (release) {
    on_click(2);
}
﻿
//----------------------------------------------------------------------
//Symbol 155 MovieClip Frame 2
//----------------------------------------------------------------------
    _alpha  = 100;
    onenterframe = function () {
        _alpha  = (_alpha - 10);
        if (_alpha <= 0) {
            delete onenterframe;
            gotoandstop (1);
        }
    }; 
